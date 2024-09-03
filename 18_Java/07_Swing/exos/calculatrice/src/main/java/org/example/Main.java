package org.example;

import org.example.layout.Calculator;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        JFrame jFrame = new JFrame("Calculator");
        jFrame.setSize(400, 500);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.setLayout(new BorderLayout());
        jFrame.add(calculator.getDisplay(), BorderLayout.NORTH);
        jFrame.add(calculator.getPanel(), BorderLayout.CENTER);
        jFrame.setVisible(true);
    }
}