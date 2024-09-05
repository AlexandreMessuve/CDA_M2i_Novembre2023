package org.example.layout;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.dao.PersonDao;
import org.example.entity.Person;
import org.example.util.Function;

import javax.swing.*;
import java.awt.*;

@EqualsAndHashCode(callSuper = true)
@Data
public class InsertPanel extends JPanel {
    private PersonDao personDao;
    private JTextField nameField;
    private JLabel nameLabel;
    private JTextField numberField;
    private JLabel numberLabel;
    private JButton submitButton;
    private JButton cancelButton;

    public  InsertPanel(PersonDao personDao) {
        this.personDao = personDao;
        setLayout(new GridBagLayout());
        GridBagConstraints gridConstraints = new GridBagConstraints();
        gridConstraints.insets = new Insets(4, 4, 4, 4);

        JPanel namePanel = new JPanel();
        nameLabel = new JLabel("Name:");
        nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(150, 24));
        namePanel.add(nameLabel);
        namePanel.add(nameField);


        JPanel numberPanel = new JPanel();
        numberField = new JTextField();
        numberLabel = new JLabel("Number:");
        numberField.setPreferredSize(new Dimension(150, 24));
        numberPanel.add(numberLabel);
        numberPanel.add(numberField);

        submitButton = new JButton("Submit");
        cancelButton = new JButton("Cancel");

        submitButton.addActionListener(e -> addPerson());

        cancelButton.addActionListener(e -> Function.close(this));

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(submitButton, BorderLayout.WEST);
        buttonPanel.add(cancelButton, BorderLayout.EAST);

        gridConstraints.gridx = 0;
        gridConstraints.gridy = 0;
        gridConstraints.gridwidth = 1;
        add(namePanel, gridConstraints);

        gridConstraints.gridy = 1;
        add(numberPanel, gridConstraints);

        gridConstraints.gridy = 2;
        add(buttonPanel, gridConstraints);
    }
    private void addPerson(){
        String name = nameField.getText();
        String number = numberField.getText();

        if (name.isEmpty() || number.isEmpty()){
            JOptionPane.showMessageDialog(this, "Name and number are required");
            return;
        }
        Person person = Person.builder()
                .name(name)
                .number(number)
                .build();
        if (personDao.savePerson(person)){
            JOptionPane.showMessageDialog(this, "Person added successfully");
            Function.close(this);
        }else{
            JOptionPane.showMessageDialog(this, "Error occurred while adding person");
        }

    }
}
