package org.example.layout;

import org.example.dao.PersonDao;
import org.example.entity.Person;

import javax.swing.*;
import java.awt.*;

public class InsertPanel extends JPanel {
    private PersonDao personDao;
    private JTextField nameField;
    private JLabel nameLabel;
    private JTextField numberField;
    private JLabel numberLabel;
    private JButton submitButton;
    private JButton cancelButton;

    public  InsertPanel(){
        setLayout(new GridLayout(2, 2));
        personDao = new PersonDao();


        JPanel namePanel = new JPanel();
        nameLabel = new JLabel("Name:");
        nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(200, 24));
        namePanel.add(nameLabel);
        namePanel.add(nameField);


        JPanel numberPanel = new JPanel();
        numberField = new JTextField();
        numberLabel = new JLabel("Number:");
        numberField.setPreferredSize(new Dimension(200, 24));
        numberPanel.add(numberLabel);
        numberPanel.add(numberField);

        submitButton = new JButton("Submit");
        cancelButton = new JButton("Cancel");

        submitButton.addActionListener(e -> {
            String name = nameField.getText();
            String number = numberField.getText();
            Person person = Person.builder()
                    .name(name)
                    .number(number)
                    .build();
            personDao.savePerson(person);
            nameField.setText("");
            numberField.setText("");
        });

        cancelButton.addActionListener(e -> {
            JDialog dialog = (JDialog) SwingUtilities.getWindowAncestor(this);
            dialog.dispose();
        });

        add(namePanel);
        add(numberPanel);
        add(submitButton);
        add(cancelButton);
    }
}
