package org.example;

import org.example.view.DepartmentUI;
import org.example.view.EmployeeUI;

import javax.swing.*;

public class MainFrame extends JFrame implements Runnable {
    public MainFrame() {
        setTitle("Main frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280, 720);
        setResizable(false);
        DepartmentUI departmentUI = new DepartmentUI();
        EmployeeUI employeeUI = new EmployeeUI();
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Department", departmentUI);
        tabbedPane.addTab("Employee", employeeUI);
        add(tabbedPane);
    }

    @Override
    public void run() {
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new MainFrame());
    }
}