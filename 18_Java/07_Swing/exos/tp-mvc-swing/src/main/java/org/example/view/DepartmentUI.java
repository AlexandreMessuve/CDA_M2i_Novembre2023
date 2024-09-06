package org.example.view;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.controller.DepartmentController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@EqualsAndHashCode(callSuper = true)
@Data
public class DepartmentUI extends JPanel {
    private final DepartmentController departmentController;
    private final JTable departmentTable;
    private String[] columnNames = {
            "ID",
            "Name",
            "Employee Count"
    };
    private DefaultTableModel tableModel;

    public DepartmentUI() {
        departmentController = new DepartmentController();
        setLayout(new BorderLayout());


        tableModel = new DefaultTableModel(columnNames, 0);
        departmentTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(departmentTable);
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

        loadDepartments();


        createButton.addActionListener(e -> createDepartment());

        updateButton.addActionListener(e -> updateDepartment());

        deleteButton.addActionListener(e -> deleteDepartment());

    }

    private void loadDepartments() {
        tableModel.setRowCount(0);
        tableModel = departmentController.getAllDepartmentsModel(tableModel);
    }

    private void createDepartment(){
        JPanel createPanel = new JPanel(new GridLayout(0, 1));
        JTextField nameField = new JTextField();
        JLabel nameLabel = new JLabel("Name:");
        createPanel.add(nameLabel);
        createPanel.add(nameField);
        int result = JOptionPane.showConfirmDialog(null, createPanel, "Create Department", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String name = nameField.getText();
            departmentController.createDepartment(name, DepartmentUI.this);
            loadDepartments();
        }
    }

    private void updateDepartment() {
        int selectedRow = departmentTable.getSelectedRow();
        if (selectedRow != -1) {
            Long id = (Long) tableModel.getValueAt(selectedRow, 0);
            String name = (String) tableModel.getValueAt(selectedRow, 1);

            JPanel updatePanel = new JPanel(new GridLayout(0, 1));
            JTextField nameField = new JTextField(name);

            updatePanel.add(new JLabel("Name:"));
            updatePanel.add(nameField);

            int result = JOptionPane.showConfirmDialog(null, updatePanel, "Update Department", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (result == JOptionPane.OK_OPTION) {
                String newName = nameField.getText();
                if (newName != null && !newName.trim().isEmpty()) {
                    departmentController.updateDepartment(id, newName, DepartmentUI.this);
                    loadDepartments();
                }
            }
        } else {
            JOptionPane.showMessageDialog(DepartmentUI.this, "Please select a department to update.");
        }
    }

    private void deleteDepartment(){
        int selectedRow = departmentTable.getSelectedRow();
        if (selectedRow != -1) {
            Long id = (Long) tableModel.getValueAt(selectedRow, 0);
            departmentController.deleteDepartment(id, DepartmentUI.this);
            loadDepartments();
        } else {
            JOptionPane.showMessageDialog(DepartmentUI.this, "Please select a department to delete.");
        }
    }
}