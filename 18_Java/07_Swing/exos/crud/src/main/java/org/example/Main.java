package org.example;

import org.example.layout.MainPanel;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Main frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setResizable(false);
        MainPanel panel = new MainPanel();
        frame.add(panel);
        frame.setVisible(true);
    }
}