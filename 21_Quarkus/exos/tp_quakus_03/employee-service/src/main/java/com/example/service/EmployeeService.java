package com.example.service;

import com.example.client.DepartmentServiceClient;
import com.example.client.OrganizationServiceClient;
import com.example.entity.Employee;
import com.example.exception.EmployeeNotFoundException;
import com.example.kafka.EmployeeKafkaProducer;
import com.example.repository.EmployeeRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import java.util.List;

@ApplicationScoped
public class EmployeeService {
    @Inject
    EmployeeRepository employeeRepository;

    @Inject
    @RestClient
    DepartmentServiceClient departmentServiceClient;

    @Inject
    @RestClient
    OrganizationServiceClient organizationServiceClient;

    @Inject
    EmployeeKafkaProducer employeeKafkaProducer;
    @Inject
    Logger logger;

    public List<Employee> getEmployees() {
        return employeeRepository.listAll().stream().map(this::enrichEmployeeDetails).toList();
    }

    public List<Employee> getEmployeesByDepartment(Long departmentId) {
        return employeeRepository.findByDepartment(departmentId).stream().map(this::enrichEmployeeDetails).toList();
    }

    public List<Employee> getEmployeesByOrganization(Long organizationId) {
        return employeeRepository.findByOrganization(organizationId).stream().map(this::enrichEmployeeDetails).toList();
    }

    public Employee getEmployeeById(Long id) {
        return enrichEmployeeDetails(employeeRepository.findByIdOptional(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id)));
    }

    @Transactional
    public Employee create(Employee employee) {
        validateEmployee(employee);
        employeeRepository.persist(employee);
        return enrichEmployeeDetails(employee);
    }

    public Employee createAndNotify(Employee employee){
        Employee createdEmployee = create(employee);
        if (employee.getOrganizationId() != null) {
            try {
                employeeKafkaProducer.publishEmployeeCreatedEvent(createdEmployee.getId(), employee.getOrganizationId());
            } catch (Exception e) {
                logger.error("Erreur lors de la publication de l'événement de création à Kafka", e);
                throw new RuntimeException("Erreur lors de la publication à Kafka", e);
            }
        }
        return enrichEmployeeDetails(createdEmployee);
    }

    @Transactional
    public Employee update(Long id, Employee employee) {
        validateEmployee(employee);
        Employee entity = employeeRepository.findById(id);
        if (entity == null) {
            throw new EmployeeNotFoundException(id);
        }
        entity.setFirstName(employee.getFirstName());
        entity.setLastName(employee.getLastName());
        entity.setBirthDate(employee.getBirthDate());
        entity.setPosition(employee.getPosition());
        entity.setOrganizationId(employee.getOrganizationId());
        entity.setDepartmentId(employee.getDepartmentId());
        employeeRepository.persist(entity);
        return enrichEmployeeDetails(entity);
    }

    @Transactional
    public void delete(Long id) {
        Employee entity = employeeRepository.findById(id);
        if (entity == null) {
            throw new EmployeeNotFoundException(id);
        }

        employeeRepository.delete(entity);
    }

    public void deleteAndNotify(Long id){
        Employee employee = employeeRepository.findById(id);

        delete(id);

        if (employee.getOrganizationId() != null) {
            try {
                employeeKafkaProducer.publishEmployeeDeletedEvent(id, employee.getOrganizationId());
            } catch (Exception e) {
                logger.error("Erreur lors de la publication de l'événement de suppression à Kafka", e);
                throw new RuntimeException("Erreur lors de la publication à Kafka", e);
            }
        }

    }

    @Transactional
    public void deleteOrganizationInEmployee(Long organizationId) {
        List<Employee> employees = employeeRepository.findByOrganization(organizationId);
        for (Employee employee : employees) {
            employee.setOrganizationId(null);
            employeeRepository.persist(employee);
        }
    }

    @Transactional
    public void deleteDepartmentInEmployee(Long departmentId) {
        List<Employee> employees = employeeRepository.findByDepartment(departmentId);
        for (Employee employee : employees) {
            employee.setDepartmentId(null);
            employeeRepository.persist(employee);
        }
    }



    private void validateEmployee(Employee employee) {
        if (employee.getFirstName() == null || employee.getFirstName().isEmpty()) {
            throw new IllegalArgumentException("First name must not be empty");
        }
        if (employee.getLastName() == null || employee.getLastName().isEmpty()) {
            throw new IllegalArgumentException("Last name must not be empty");
        }
        if (employee.getBirthDate() == null) {
            throw new IllegalArgumentException("Birth date must not be empty");
        }
        if (employee.getPosition() == null || employee.getPosition().isEmpty()) {
            throw new IllegalArgumentException("Position must not be empty");
        }
    }

    private Employee enrichEmployeeDetails(Employee employee) {
        if (employee.getOrganizationId() != null) {
            employee.setOrganization(organizationServiceClient.getOrganizationById(employee.getOrganizationId()));
        }
        if (employee.getDepartmentId() != null) {
            employee.setDepartment(departmentServiceClient.getDepartmentById(employee.getDepartmentId()));
        }
        return employee;
    }
}
