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
public class UpdatePanel extends JPanel {
    private PersonDao personDao;
    private JPanel idPanel;
    private JLabel idLabel;
    private JTextField idField;
    private JButton searchButton;
    private JLabel nameLabel;
    private JTextField nameField;
    private JPanel namePanel;
    private JLabel numberLabel;
    private JTextField numberField;
    private JPanel numberPanel;
    private JButton updateButton;
    private JButton cancelButton;
    private JPanel buttonPanel;
    public UpdatePanel(PersonDao personDao) {
        this.personDao = personDao;
        setLayout(new GridBagLayout());
        GridBagConstraints gridConstraint = new GridBagConstraints();
        gridConstraint.insets = new Insets(4, 4, 4, 4);
        gridConstraint.fill = GridBagConstraints.HORIZONTAL;

        idPanel = new JPanel();
        idLabel = new JLabel("ID ");
        idField = new JTextField();
        idField.setPreferredSize(new Dimension(100, 24));
        searchButton = new JButton("Search");

        searchButton.addActionListener(e -> search());

        idPanel.add(idLabel, BorderLayout.WEST);
        idPanel.add(idField, BorderLayout.CENTER);
        idPanel.add(searchButton, BorderLayout.EAST);


        namePanel = new JPanel();
        nameLabel = new JLabel("Name");
        nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(100, 24));
        namePanel.add(nameLabel, BorderLayout.WEST);
        namePanel.add(nameField, BorderLayout.EAST);

        numberPanel = new JPanel();
        numberLabel = new JLabel("Number");
        numberField = new JTextField();
        numberField.setPreferredSize(new Dimension(100, 24));
        numberPanel.add(numberLabel, BorderLayout.WEST);
        numberPanel.add(numberField, BorderLayout.EAST);

        updateButton = new JButton("Update");
        cancelButton = new JButton("Cancel");
        buttonPanel = new JPanel();
        updateButton.addActionListener(e -> update());
        cancelButton.addActionListener(e -> Function.close(this));
        buttonPanel.add(updateButton, BorderLayout.EAST);
        buttonPanel.add(cancelButton, BorderLayout.WEST);

        gridConstraint.gridx = 0;
        gridConstraint.gridy = 0;
        gridConstraint.gridwidth = 2;
        add(idPanel, gridConstraint);

        gridConstraint.gridy = 1;
        gridConstraint.gridwidth = 1;
        add(namePanel, gridConstraint);

        gridConstraint.gridy = 2;
        add(numberPanel, gridConstraint);

        gridConstraint.gridy = 3;
        gridConstraint.gridwidth = 2;
        add(buttonPanel, gridConstraint);
    }

    private void search(){
        personDao = new PersonDao();
        Long id = Long.parseLong(idField.getText());
        Person person = personDao.getPersonById(id);
        if (person == null){
            JOptionPane.showMessageDialog(this, "Person not found");
            return;
        }
        nameField.setText(person.getName());
        numberField.setText(person.getNumber());
    }

    private void update(){
        Long id = Long.parseLong(idField.getText());
        String name = nameField.getText();
        String number = numberField.getText();
        Person person = Person.builder().id(id).name(name).number(number).build();
        if (personDao.savePerson(person)) {
            JOptionPane.showMessageDialog(this, "Person updated successfully");
            Function.close(this);
        }else{
            JOptionPane.showMessageDialog(this, "Error occurred while updating person");
        }
    }
}
