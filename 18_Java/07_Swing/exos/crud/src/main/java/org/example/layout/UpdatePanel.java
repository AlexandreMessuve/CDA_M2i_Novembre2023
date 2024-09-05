package org.example.layout;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.dao.PersonDao;
import org.example.entity.Person;

import javax.swing.*;
import java.awt.*;

@EqualsAndHashCode(callSuper = true)
@Data
public class UpdatePanel extends JPanel {
    private PersonDao personDao;
    private JPanel searchPanel;
    private JLabel searchLabel;
    private JTextField searchField;
    private JButton searchButton;
    private JLabel nameLabel;
    private JTextField nameField;
    private JPanel namePanel;
    private JLabel numberLabel;
    private JTextField numberField;
    private JPanel numberPanel;
    private JPanel formPanel;
    private JButton updateButton;
    private JButton cancelButton;
    private JPanel buttonPanel;
    public UpdatePanel(PersonDao personDao) {
        this.personDao = personDao;
        setLayout(new BorderLayout());

        searchPanel = new JPanel();
        searchLabel = new JLabel("Search");
        searchField = new JTextField();
        searchField.setPreferredSize(new Dimension(200, 24));
        searchButton = new JButton("Search");

        searchButton.addActionListener(e -> search());

        searchPanel.add(searchLabel, BorderLayout.WEST);
        searchPanel.add(searchField, BorderLayout.CENTER);
        searchPanel.add(searchButton, BorderLayout.EAST);

        add(searchPanel, BorderLayout.NORTH);

        namePanel = new JPanel();
        nameLabel = new JLabel("Name");
        nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(200, 24));
        namePanel.add(nameLabel, BorderLayout.WEST);
        namePanel.add(nameField, BorderLayout.EAST);

        numberPanel = new JPanel();
        numberLabel = new JLabel("Number");
        numberField = new JTextField();
        numberField.setPreferredSize(new Dimension(200, 24));
        numberPanel.add(numberLabel, BorderLayout.WEST);
        numberPanel.add(numberField, BorderLayout.EAST);

        formPanel = new JPanel();
        formPanel.add(namePanel, BorderLayout.NORTH);
        formPanel.add(numberLabel, BorderLayout.SOUTH);

        add(formPanel, BorderLayout.CENTER);

        updateButton = new JButton("Update");
        cancelButton = new JButton("Cancel");
        buttonPanel = new JPanel();
        updateButton.addActionListener(e -> update());
        cancelButton.addActionListener(e -> cancel());
        buttonPanel.add(updateButton, BorderLayout.EAST);
        buttonPanel.add(cancelButton, BorderLayout.WEST);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void search(){
        personDao = new PersonDao();
        Long id = Long.parseLong(searchField.getText());
        Person person = personDao.getPersonById(id);
        nameField.setText(person.getName());
        numberField.setText(person.getNumber());
    }

    private void update(){
        Long id = Long.parseLong(searchField.getText());
        String name = nameField.getText();
        String number = numberField.getText();
        Person person = Person.builder().id(id).name(name).number(number).build();
        personDao.savePerson(person);
    }

    private void cancel(){
        JDialog dialog = (JDialog) SwingUtilities.getWindowAncestor(this);
        dialog.dispose();
    }
}
