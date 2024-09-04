package org.example.layout;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.swing.*;
import java.awt.*;

@EqualsAndHashCode(callSuper = true)
@Data
public class MainPanel extends JPanel {

    private final JButton selectButton;

    private final JButton updateButton;

    private final JButton deleteButton;

    private final JButton insertButton;

    private JDialog dialog;


    public MainPanel() {
        setLayout(new BorderLayout(4,4));
        Insets insets = new Insets(4, 4, 4, 4);

        insertButton = new JButton("Insert");
        insertButton.addActionListener(e -> showDialog("Insert"));
        updateButton = new JButton("Update");

        deleteButton = new JButton("Delete");
        selectButton = new JButton("Select");
        selectButton.addActionListener(e -> showDialog("Select"));

        JPanel firstRow = new JPanel(new GridBagLayout());
        firstRow.add(insertButton, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        firstRow.add(updateButton, new GridBagConstraints(1, 0, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        firstRow.add(deleteButton, new GridBagConstraints(2, 0, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));

        JPanel secondRow = new JPanel(new GridBagLayout());
        secondRow.add(selectButton, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE, insets, 0, 0));

        add(firstRow, BorderLayout.NORTH);
        add(secondRow, BorderLayout.CENTER);
    }

    private void showDialog(String title) {
        JPanel panel = switch (title) {
            case "Insert" -> new InsertPanel();
            case "Update" -> new UpdatePanel();
            case "Delete" -> new DeletePanel();
            case "Select" -> new SelectPanel();
            default -> null;
        };
        dialog = new JDialog();
        dialog.setTitle(title);
        dialog.add(panel);
        dialog.setSize(500, 600);
        dialog.setVisible(true);
    }
}
