package com.example.service;

import com.example.client.OrganizationServiceClient;
import com.example.dto.OrganizationDto;
import com.example.entity.Department;
import com.example.exception.DepartmentNotFoundException;
import com.example.kafka.DepartmentKafkaProducer;
import com.example.repository.DepartmentRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import java.util.List;

@ApplicationScoped
public class DepartmentService {

    @Inject
    DepartmentRepository departmentRepository;

    @Inject
    @RestClient
    OrganizationServiceClient organizationServiceClient;

    @Inject
    DepartmentKafkaProducer departmentKafkaProducer;
    @Inject
    Logger logger;

    public List<Department> findAll() {
        return departmentRepository.listAll().stream().map(this::enrichDepartmentDetails).toList();
    }

    public List<Department> findByOrganizationId(Long organizationId) {
        return departmentRepository.findByOrganizationId(organizationId).stream().map(this::enrichDepartmentDetails).toList();
    }

    public Department findById(Long id) {
        return enrichDepartmentDetails(departmentRepository.findByIdOptional(id)
                .orElseThrow(() -> new DepartmentNotFoundException(id)));
    }

    @Transactional
    public Department create(Department department) {
        validateDepartment(department);
        departmentRepository.persist(department);
        return enrichDepartmentDetails(department);
    }


    @Transactional
    public Department update(Long id, Department department) {
        Department entity = departmentRepository.findById(id);
        if (entity == null) {
            throw new DepartmentNotFoundException(id);
        }
        entity.setName(department.getName());
        entity.setOrganizationId(department.getOrganizationId());
        departmentRepository.persist(entity);
        return enrichDepartmentDetails(entity);
    }

    @Transactional
    public void delete(Long id) {
        Department department = departmentRepository.findById(id);
        if (department == null) {
            throw new DepartmentNotFoundException(id);
        }

        departmentRepository.deleteById(id);
    }

    public void deleteAndNotify(Long id) {
        delete(id);

        try {
            departmentKafkaProducer.publishDepartmentDeletedEvent(id);
        } catch (Exception e) {
            logger.error("Erreur lors de la publication de l'événement de suppression à Kafka", e);
            throw new RuntimeException("Erreur lors de la publication à Kafka", e);
        }
    }

    @Transactional
    public void deleteOrganizationInDepartment(Long organizationId){
        List<Department> departments = departmentRepository.findByOrganizationId(organizationId);
        for (Department department : departments) {
            department.setOrganizationId(null);
            departmentRepository.persist(department);
        }
    }

    private void validateDepartment(Department department) {
        if (department.getName() == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
    }

    private Department enrichDepartmentDetails(Department department) {
        if (department.getOrganizationId() == null) {
            return department;
        }
        OrganizationDto organizationDto = organizationServiceClient.getOrganizationById(department.getOrganizationId());
        if (organizationDto != null){
            department.setOrganization(organizationDto);
        }
        return department;
    }
}
