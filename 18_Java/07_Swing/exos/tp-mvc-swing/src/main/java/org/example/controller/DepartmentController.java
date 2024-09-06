package org.example.controller;

import lombok.Data;
import org.example.dao.DepartmentDAO;
import org.example.model.Department;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

@Data
public class DepartmentController {
    private DepartmentDAO departmentDAO = new DepartmentDAO();

    public DepartmentController() {
        departmentDAO = new DepartmentDAO();
    }

    public void createDepartment(String name, JPanel panel) {
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(panel, "Please enter the name !");
            return;
        }
        Department department = Department.builder().name(name).build();
        if(departmentDAO.create(department)){
            JOptionPane.showMessageDialog(panel, "Department created successfully");
        } else {
            JOptionPane.showMessageDialog(panel, "Error creating department");
        }
    }

    public void updateDepartment(Long id, String name, JPanel panel) {
        Department department = Department.builder().id(id).name(name).build();
        if(departmentDAO.update(department)){
            JOptionPane.showMessageDialog(panel, "Department updated successfully");
        } else {
            JOptionPane.showMessageDialog(panel, "Error updating department");
        }
    }

    public void deleteDepartment(Long id, JPanel panel) {
        if(departmentDAO.delete(id)){
            JOptionPane.showMessageDialog(panel, "Department deleted successfully");
        } else {
            JOptionPane.showMessageDialog(panel, "Error deleting department");
        }
    }

    public Department getDepartmentById(Long id) {
        return departmentDAO.read(id);
    }

    public List<Department> getAllDepartments() {
        return departmentDAO.findAll();
    }

    public DefaultTableModel getAllDepartmentsModel(DefaultTableModel model) {
        List<Department> departments = departmentDAO.findAll();
        if (departments.isEmpty()) {
            return model;
        }
        departments.forEach(department -> {
            model.addRow(new Object[]{department.getId(), department.getName(), department.getEmployees().size()});
        });
        return model;
    }
}
