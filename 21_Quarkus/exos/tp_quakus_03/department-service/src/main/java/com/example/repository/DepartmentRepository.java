package com.example.repository;

import com.example.entity.Department;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class DepartmentRepository implements PanacheRepository<Department> {
    public List<Department> findByOrganizationId(Long organizationId) {
        System.out.println(organizationId);
        if (organizationId == -1) {
            return list("organizationId is null");
        }
        return list("organizationId", organizationId);
    }

    public Department findByName(String name) {
        return find("name", name).firstResult();
    }
}
