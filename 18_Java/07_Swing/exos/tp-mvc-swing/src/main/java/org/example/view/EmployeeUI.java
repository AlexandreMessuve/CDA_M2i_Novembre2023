package org.example.view;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.controller.DepartmentController;
import org.example.controller.EmployeeController;
import org.example.model.Department;
import org.example.model.Role;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class EmployeeUI extends JPanel {
    private EmployeeController employeeController;
    private JTable employeeTable;
    private String[] columnNames = {
            "ID",
            "First Name",
            "Last Name",
            "Role",
            "Department"
    };
    private DefaultTableModel tableModel;
    private DepartmentController departmentController;

    public EmployeeUI() {
        departmentController = new DepartmentController();
        employeeController = new EmployeeController();
        setLayout(new BorderLayout());

        tableModel = new DefaultTableModel(columnNames, 0);
        employeeTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(employeeTable);
        add(scrollPane, BorderLayout.NORTH);


        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton createButton = new JButton("Create");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");

        buttonPanel.add(createButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        add(buttonPanel, BorderLayout.SOUTH);


        loadEmployees();


        createButton.addActionListener(e -> createEmployee());

        updateButton.addActionListener(e -> updateEmployee());

        deleteButton.addActionListener(e -> deleteEmployee());
    }

    public void loadEmployees() {
        tableModel.setRowCount(0);
        tableModel = employeeController.getEmployeeModel(tableModel);
    }

    private void createEmployee(){
        JPanel createPanel = new JPanel(new GridLayout(0, 1));
        JTextField firstNameField = new JTextField();
        JTextField lastNameField = new JTextField();

        createPanel.add(new JLabel("First Name:"));
        createPanel.add(firstNameField);
        createPanel.add(new JLabel("Last Name:"));
        createPanel.add(lastNameField);
        createPanel.add(new JLabel("Department:"));
        JComboBox<Department> departmentComboBox = new JComboBox<>();

        List<Department> departments = departmentController.getAllDepartments();
        for (Department department : departments) {
            departmentComboBox.addItem(department);
        }
        createPanel.add(departmentComboBox);


        createPanel.add(new JLabel("Role:"));
        ButtonGroup roleGroup = new ButtonGroup();
        for (Role role : Role.values()) {
            JRadioButton radioButton = new JRadioButton(role.name());
            radioButton.setActionCommand(role.name());
            roleGroup.add(radioButton);
            createPanel.add(radioButton);
        }

        int result = JOptionPane.showConfirmDialog(null, createPanel, "Create Employee", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            Department selectedDepartment = (Department) departmentComboBox.getSelectedItem();
            String role = roleGroup.getSelection().getActionCommand();
            employeeController.createEmployee(firstName, lastName, role, selectedDepartment, EmployeeUI.this);
            loadEmployees();
        }
    }

    private void updateEmployee(){
        int selectedRow = employeeTable.getSelectedRow();
        if (selectedRow != -1) {
            Long id = (Long) tableModel.getValueAt(selectedRow, 0);
            String firstName = (String) tableModel.getValueAt(selectedRow, 1);
            String lastName = (String) tableModel.getValueAt(selectedRow, 2);
            Role role = (Role) tableModel.getValueAt(selectedRow, 3);
            Department department = (Department) tableModel.getValueAt(selectedRow, 4);

            JPanel updatePanel = new JPanel(new GridLayout(0, 1));
            JTextField firstNameField = new JTextField(firstName);
            JTextField lastNameField = new JTextField(lastName);

            updatePanel.add(new JLabel("First Name:"));
            updatePanel.add(firstNameField);
            updatePanel.add(new JLabel("Last Name:"));
            updatePanel.add(lastNameField);

            updatePanel.add(new JLabel("Department:"));
            JComboBox<Department> departmentComboBox = new JComboBox<>();
            List<Department> departments = departmentController.getAllDepartments();
            for (Department dept : departments) {
                departmentComboBox.addItem(dept);
            }
            departmentComboBox.setSelectedItem(department);
            updatePanel.add(departmentComboBox);

            updatePanel.add(new JLabel("Role:"));
            ButtonGroup roleGroup = new ButtonGroup();
            for (Role r : Role.values()) {
                JRadioButton radioButton = new JRadioButton(r.name());
                radioButton.setActionCommand(r.name());
                if (r == role) {
                    radioButton.setSelected(true);
                }
                roleGroup.add(radioButton);
                updatePanel.add(radioButton);
            }

            int result = JOptionPane.showConfirmDialog(null, updatePanel, "Update Employee", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (result == JOptionPane.OK_OPTION) {
                String newFirstName = firstNameField.getText();
                String newLastName = lastNameField.getText();
                Department newDepartment = (Department) departmentComboBox.getSelectedItem();
                String newRole = roleGroup.getSelection().getActionCommand();
                employeeController.updateEmployee(id, newFirstName, newLastName, newRole, newDepartment, EmployeeUI.this);
                loadEmployees();
            }
        } else {
            JOptionPane.showMessageDialog(EmployeeUI.this, "Please select an employee to update.");
        }
    }

    private void deleteEmployee(){
        int selectedRow = employeeTable.getSelectedRow();
        if (selectedRow != -1) {
            Long id = (Long) tableModel.getValueAt(selectedRow, 0);
            employeeController.deleteEmployee(id, EmployeeUI.this);
            loadEmployees();
        } else {
            JOptionPane.showMessageDialog(EmployeeUI.this, "Please select an employee to delete.");
        }
    }
}