package org.example.layout;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.dao.PersonDao;

import javax.swing.*;
import java.awt.*;

@EqualsAndHashCode(callSuper = true)
@Data
public class MainPanel extends JPanel {

    private final PersonDao personDao;

    private final JButton selectButton;

    private final JButton updateButton;

    private final JButton deleteButton;

    private final JButton insertButton;

    private JDialog dialog;


    public MainPanel() {
        personDao = new PersonDao();
        // load data in starting application
        personDao.getAllPersons();

        setLayout(new GridBagLayout());
        GridBagConstraints gridConstraints = new GridBagConstraints();
        Insets insets = new Insets(4, 4, 4, 4);
        gridConstraints.insets = insets;

        insertButton = new JButton("Insert");
        insertButton.addActionListener(e -> showDialog("Insert"));
        updateButton = new JButton("Update");
        updateButton.addActionListener(e -> showDialog("Update"));
        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(e -> showDialog("Delete"));
        selectButton = new JButton("Select");
        selectButton.addActionListener(e -> showDialog("Select"));


        gridConstraints.gridx = 0;
        gridConstraints.gridy = 0;
        add(insertButton, gridConstraints);

        gridConstraints.gridx = 1;
        add(updateButton, gridConstraints);

        gridConstraints.gridx = 2;
        add(deleteButton, gridConstraints);

        gridConstraints.gridy = 1;
        gridConstraints.gridx = 1;
        add(selectButton, gridConstraints);
    }

    private void showDialog(String title) {
        JPanel panel = switch (title) {
            case "Insert" -> new InsertPanel(personDao);
            case "Update" -> new UpdatePanel(personDao);
            case "Delete" -> new DeletePanel(personDao);
            case "Select" -> new SelectPanel(personDao);
            default -> null;
        };
        dialog = new JDialog();
        dialog.setTitle(title);
        dialog.add(panel);
        dialog.setLocationRelativeTo(this);
        dialog.setResizable(false);
        switch (title){
            case "Insert" -> dialog.setSize(300, 200);
            case "Update" -> dialog.setSize(300, 250);
            case "Delete" -> dialog.setSize(300, 150);
            case "Select" -> dialog.setSize(350, 400);
        }
        dialog.setVisible(true);
    }
}
