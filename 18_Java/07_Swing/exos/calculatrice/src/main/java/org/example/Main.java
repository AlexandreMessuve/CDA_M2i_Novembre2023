package org.example;

import org.example.layout.Calculator;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        JFrame jFrame = new JFrame("Calculator");
        jFrame.setSize(300, 400);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        jFrame.setLocationRelativeTo(null);
        jFrame.setLayout(new BorderLayout());
        jFrame.add(calculator.getPanel());
        jFrame.setBackground(Color.BLACK);
        jFrame.setVisible(true);
    }
}