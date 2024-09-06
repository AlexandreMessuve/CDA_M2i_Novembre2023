package org.example.dao;

import org.example.model.Employee;

public class EmployeeDAO extends BaseDAO<Employee> {
    public EmployeeDAO() {
        super(Employee.class);
    }
}
