package org.example.layout;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.dao.PersonDao;

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
    private final PersonDao personDao = new PersonDao();

    public SelectPanel() {
        table = new JTable();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        tableModel = new DefaultTableModel(columnNames, 0);
        table.setModel(tableModel);
        personDao.getAllPersons().forEach(person -> tableModel.addRow(new Object[]{person.getId(),person.getName(), person.getNumber()}));
        add(new JScrollPane(table));
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> {
            JDialog dialog = (JDialog) SwingUtilities.getWindowAncestor(this);
            dialog.dispose();
        });
        add(closeButton, BorderLayout.EAST);
        setBorder(BorderFactory.createTitledBorder("Table data"));
    }



}
