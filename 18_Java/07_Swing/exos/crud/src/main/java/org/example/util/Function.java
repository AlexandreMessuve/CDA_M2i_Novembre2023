package org.example.util;

import javax.swing.*;

public class Function {
    public static void close(JPanel panel) {
        JDialog dialog = (JDialog) SwingUtilities.getWindowAncestor(panel);
        dialog.dispose();
    }
}
