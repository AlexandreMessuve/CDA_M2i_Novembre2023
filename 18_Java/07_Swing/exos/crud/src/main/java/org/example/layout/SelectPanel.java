package org.example.layout;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.dao.PersonDao;
import org.example.util.Function;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

@EqualsAndHashCode(callSuper = true)
@Data
public class SelectPanel extends JPanel {
    private JTable table;
    private final String[] columnNames = {
            "ID",
            "Name",
            "Number"
    };
    private DefaultTableModel tableModel;
    private final PersonDao personDao;

    public SelectPanel(PersonDao personDao) {
        this.personDao = personDao;
        table = new JTable();

        setLayout(new GridBagLayout());
        GridBagConstraints gridConstraints = new GridBagConstraints();
        gridConstraints.insets = new Insets(4, 4, 4, 4);

        tableModel = new DefaultTableModel(columnNames, 0);
        table.setModel(tableModel);
        table.setBackground(Color.WHITE);
        personDao.getAllPersons().forEach(person -> tableModel.addRow(new Object[]{person.getId(),person.getName(), person.getNumber()}));

        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> Function.close(this));


        gridConstraints.gridx = 0;
        gridConstraints.gridy = 0;
        gridConstraints.gridwidth = 2;
        gridConstraints.fill = GridBagConstraints.BOTH;
        gridConstraints.weightx = 1.0;
        gridConstraints.weighty = 1.0;
        add(new JScrollPane(table), gridConstraints);

        gridConstraints.gridx = 1;
        gridConstraints.gridy = 1;
        gridConstraints.gridwidth = 1;
        gridConstraints.fill = GridBagConstraints.NONE;
        gridConstraints.weightx = 0;
        gridConstraints.weighty = 0;
        add(closeButton, gridConstraints);
    }



}
