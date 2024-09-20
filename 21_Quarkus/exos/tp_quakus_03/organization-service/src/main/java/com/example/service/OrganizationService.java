package com.example.service;

import com.example.entity.Organization;
import com.example.exception.OrganizationNotFoundException;
import com.example.kafka.OrganizationKafkaProducer;
import com.example.reporsitory.OrganizationRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.jboss.logging.Logger;

import java.time.LocalDateTime;
import java.util.List;

@ApplicationScoped
public class OrganizationService {
    @Inject
    OrganizationRepository organizationRepository;

    @Inject
    OrganizationKafkaProducer organizationKafkaProducer;
    @Inject
    Logger logger;

    public List<Organization> findAll() {
        return organizationRepository.listAll();
    }

    public Organization findById(Long id) {
        return organizationRepository.findByIdOptional(id)
                .orElseThrow(() -> new OrganizationNotFoundException(id));
    }

    @Transactional
    public Organization create(Organization organization) {
        validateOrganization(organization);
        organization.setNumberOfEmployees(0);
        organization.setDateLastJoinedOrLeftEmployee(null);
        organizationRepository.persist(organization);
        return organization;
    }

    @Transactional
    public Organization update(Long id, Organization organization) {
        validateOrganization(organization);
        Organization entity = organizationRepository.findById(id);
        if (entity == null) {
            throw new OrganizationNotFoundException(id);
        }
        entity.setName(organization.getName());
        entity.setAddress(organization.getAddress());
        organizationRepository.persist(entity);
        return entity;
    }

    @Transactional
    public void incrementNumberOfEmployees(Long id){
        Organization entity = organizationRepository.findById(id);
        if (entity == null) {
            throw new OrganizationNotFoundException(id);
        }
        entity.setNumberOfEmployees(entity.getNumberOfEmployees() + 1);
        entity.setDateLastJoinedOrLeftEmployee(LocalDateTime.now());
        organizationRepository.persist(entity);
    }

    @Transactional
    public void decrementNumberOfEmployees(Long id){
        Organization entity = organizationRepository.findById(id);
        if (entity == null) {
            throw new OrganizationNotFoundException(id);
        }
        entity.setNumberOfEmployees(entity.getNumberOfEmployees() - 1);
        entity.setDateLastJoinedOrLeftEmployee(LocalDateTime.now());
        organizationRepository.persist(entity);
    }

    @Transactional
    public void delete(Long id) {
        Organization organization = organizationRepository.findById(id);
        if (organization == null) {
            throw new OrganizationNotFoundException(id);
        }

        organizationRepository.deleteById(id);
    }

    public void deleteAndNotify(Long id) {
        delete(id);

        try {
            organizationKafkaProducer.publishOrganizationDeletedEvent(id);
        } catch (Exception e) {
            logger.error("Erreur lors de la publication de l'événement de suppression à Kafka", e);
            throw new RuntimeException("Erreur lors de la publication à Kafka", e);
        }
    }

    private void validateOrganization(Organization organization) {
        if (organization.getName() == null || organization.getName().isBlank()) {
            throw new IllegalArgumentException("Organization name must not be blank");
        }
        if (organization.getAddress() == null || organization.getAddress().isBlank()) {
            throw new IllegalArgumentException("Organization address must not be blank");
        }
    }
}
