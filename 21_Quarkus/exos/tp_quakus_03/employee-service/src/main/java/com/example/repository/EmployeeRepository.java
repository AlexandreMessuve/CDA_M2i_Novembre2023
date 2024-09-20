package com.example.repository;

import com.example.entity.Employee;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class EmployeeRepository implements PanacheRepository<Employee> {
    public List<Employee> findByOrganization(Long organizationId) {
        if (organizationId == -1){
            return list("organizationId is null");
        }
        return list("organizationId", organizationId);
    }

    public List<Employee> findByDepartment(Long departmentId) {
        if (departmentId == -1){
            return list("departmentId is null");
        }
        return list("departmentId", departmentId);
    }
}
