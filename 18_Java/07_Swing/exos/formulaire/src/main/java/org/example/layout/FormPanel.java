package org.example.layout;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.swing.*;
import java.awt.*;

@EqualsAndHashCode(callSuper = true)
@Data
public class FormPanel extends JPanel {
    private TablePanel tablePanel;
    private JTextField nameField;
    private JTextField emailField;
    private JRadioButton maleButton;
    private JRadioButton femaleButton;
    private JButton submitButton;

    public FormPanel(TablePanel tablePanel) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.tablePanel = tablePanel;

        JPanel namePanel = new JPanel();
        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(200, 24));
        namePanel.add(nameLabel);
        namePanel.add(nameField);
        add(namePanel);

        JPanel emailPanel = new JPanel();
        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField();
        emailField.setPreferredSize(new Dimension(200, 24));
        emailPanel.add(emailLabel);
        emailPanel.add(emailField);
        add(emailPanel);

        JPanel genderPanel = new JPanel();
        JLabel genderLabel = new JLabel("Gender:");
        maleButton = new JRadioButton("Male");
        femaleButton = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);
        genderPanel.add(genderLabel);
        genderPanel.add(maleButton);
        genderPanel.add(new JLabel());
        genderPanel.add(femaleButton);
        add(genderPanel);


        JPanel buttonPanel = new JPanel();
        submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> submitForm());
        buttonPanel.add(submitButton);
        add(buttonPanel);
        setBorder(BorderFactory.createTitledBorder("Form add"));
    }

    public void submitForm() {
            String name = nameField.getText();
            String email = emailField.getText();
            String gender = maleButton.isSelected() ? "Male" : "Female";
            tablePanel.add(name, email, gender);
    }
}