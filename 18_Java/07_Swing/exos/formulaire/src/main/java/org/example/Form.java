package org.example;

import org.example.layout.FormPanel;
import org.example.layout.TablePanel;

import javax.swing.*;
import java.awt.*;

public class Form {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Formulaire");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(500, 600);
        TablePanel tablePanel = new TablePanel();
        FormPanel formPanel = new FormPanel(tablePanel);

        frame.add(formPanel, BorderLayout.NORTH);
        frame.add(tablePanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}