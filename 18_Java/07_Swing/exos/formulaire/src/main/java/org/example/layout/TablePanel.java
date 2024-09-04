package org.example.layout;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

@EqualsAndHashCode(callSuper = true)
@Data
public class TablePanel extends JPanel {
    private JTable table;
    private DefaultTableModel tableModel;
    private JDialog dialog;

    public TablePanel() {
        table = new JTable();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Name");
        tableModel.addColumn("Email");
        tableModel.addColumn("Gender");
        table.setModel(tableModel);
        add(new JScrollPane(table));
        setBorder(BorderFactory.createTitledBorder("Table data"));

        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = table.rowAtPoint(evt.getPoint());
                if (row >= 0) {
                    String name = tableModel.getValueAt(row, 0).toString();
                    String email = tableModel.getValueAt(row, 1).toString();
                    String gender = tableModel.getValueAt(row, 2).toString();
                    showDialog(name, email, gender);
                }
            }
        });
    }

    private void showDialog(String name, String email, String gender) {
        dialog = new JDialog();
        dialog.setTitle("Details");
        dialog.setLayout(new GridLayout(3, 3));
        dialog.add(new JLabel("Name:"));
        dialog.add(new JLabel(name));
        dialog.add(new JLabel("Email:"));
        dialog.add(new JLabel(email));
        dialog.add(new JLabel("Gender:"));
        dialog.add(new JLabel(gender));
        dialog.setSize(200, 100);
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    public void add(String name, String email, String gender) {
        tableModel.addRow(new Object[]{name, email, gender});
    }
}
