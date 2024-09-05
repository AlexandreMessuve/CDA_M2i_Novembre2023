package org.example.layout;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.dao.PersonDao;
import org.example.util.Function;

import javax.swing.*;
import java.awt.*;

@EqualsAndHashCode(callSuper = true)
@Data
public class DeletePanel extends JPanel {
    private PersonDao personDao;
    private JTextField idField;
    private JButton deleteButton;
    private JButton cancelButton;

    public DeletePanel(PersonDao personDao) {
        this.personDao = personDao;
        setLayout(new GridBagLayout());
        GridBagConstraints gridConstraints = new GridBagConstraints();
        gridConstraints.insets = new Insets(4, 4, 4, 4);

        idField = new JTextField();
        idField.setPreferredSize(new Dimension(100, 24));
        deleteButton = new JButton("Delete");
        cancelButton = new JButton("Cancel");

        deleteButton.addActionListener(e -> deletePerson());
        cancelButton.addActionListener(e -> Function.close(this));
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(deleteButton, BorderLayout.WEST);
        buttonPanel.add(cancelButton, BorderLayout.EAST);

        gridConstraints.gridx = 0;
        gridConstraints.gridy = 0;
        gridConstraints.gridwidth = 1;
        add(new JLabel("ID:"), gridConstraints);

        gridConstraints.gridx = 1;
        add(idField, gridConstraints);

        gridConstraints.gridx = 1;
        gridConstraints.gridy = 1;
        add(buttonPanel, gridConstraints);
    }
    private void deletePerson(){
        if (idField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "ID is required");
            return;
        }
        Long id = Long.parseLong(idField.getText());
        if (personDao.deleteById(id)){
            JOptionPane.showMessageDialog(this, "Person deleted successfully");
            Function.close(this);
        } else {
            JOptionPane.showMessageDialog(this, "Person not found");
        }
    }
}
