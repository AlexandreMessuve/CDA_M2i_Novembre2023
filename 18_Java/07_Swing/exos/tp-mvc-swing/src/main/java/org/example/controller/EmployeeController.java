package org.example.controller;

import lombok.Data;
import org.example.dao.EmployeeDAO;
import org.example.model.Department;
import org.example.model.Employee;
import org.example.model.Role;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

@Data
public class EmployeeController {
    private final EmployeeDAO employeeDAO;

    public EmployeeController() {
        this.employeeDAO = new EmployeeDAO();
    }

    public void createEmployee(String firstName, String lastName, String role, Department department, JPanel panel) {
        if (firstName.isEmpty() || lastName.isEmpty() || role.isEmpty() || department == null) {
            JOptionPane.showMessageDialog(panel, "Please fill all fields");
            return;
        }
        Employee employee =Employee.builder()
                .firstName(firstName)
                .lastName(lastName)
                .role(Role.valueOf(role))
                .department(department)
                .build();
        if (employeeDAO.create(employee)) {
            JOptionPane.showMessageDialog(panel, "Employee created successfully");
        } else {
            JOptionPane.showMessageDialog(panel, "Error creating employee");
        }
    }

    public void updateEmployee(Long id, String firstName, String lastName, String role, Department department, JPanel panel) {
        if (firstName.isEmpty() || lastName.isEmpty() || role.isEmpty() || department == null) {
            JOptionPane.showMessageDialog(panel, "Please fill all fields");
            return;
        }
        Employee employee = Employee.builder()
                .id(id)
                .firstName(firstName)
                .lastName(lastName)
                .role(Role.valueOf(role))
                .department(department)
                .build();
        if (employeeDAO.update(employee)) {
            JOptionPane.showMessageDialog(panel, "Employee updated successfully");
        } else {
            JOptionPane.showMessageDialog(panel, "Error updating employee");
        }
    }

    public void deleteEmployee(Long id, JPanel panel) {
        if (employeeDAO.delete(id)) {
            JOptionPane.showMessageDialog(panel, "Employee deleted successfully");
        } else {
            JOptionPane.showMessageDialog(panel, "Error deleting employee");
        }
    }

    public Employee readEmployee(Long id) {
        return employeeDAO.read(id);
    }

    public List<Employee> findAllEmployees() {
        return employeeDAO.findAll();
    }

    public DefaultTableModel getEmployeeModel(DefaultTableModel model) {
        List<Employee> employees = employeeDAO.findAll();
        if (employees.isEmpty()){
            return model;
        }
        employees.forEach(employee -> {
            model.addRow(new Object[]{
                    employee.getId(),
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getRole(),
                    employee.getDepartment()
            });
        });
        return model;
    }
}
