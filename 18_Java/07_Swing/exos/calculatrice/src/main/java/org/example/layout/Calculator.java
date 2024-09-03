package org.example.layout;

import lombok.Data;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;

@Data
public class Calculator {
    private JTextField display;
    private JPanel panel;
    private String[] buttons = {
            "C", "+/-", "%", "/",
            "7", "8", "9", "*",
            "4", "5", "6", "-",
            "1", "2", "3", "+",
            "0","", ",", "="
    };
    private String currentInput = "0";
    private String operator = "";
    private double firstOperand = 0;

    public Calculator() {
        display = new JTextField();
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setFont(new Font("Arial", Font.BOLD, 75));
        display.setText("0");
        display.setForeground(Color.WHITE);
        display.setBackground(Color.BLACK);
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        buttonPanel.setBackground(Color.BLACK);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(10, 10, 10, 10);

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 20));
            button.addActionListener(this::calculate);
            styleButton(button, text);
            if (text.equals("0")) {
                constraints.gridwidth = 2;
                constraints.gridx = 0;
                constraints.gridy = 4;
            }  else {
                int index = Arrays.asList(buttons).indexOf(text);
                constraints.gridwidth = 1;
                constraints.gridx = index % 4;
                constraints.gridy = index / 4;
            }
            buttonPanel.add(button, constraints);
        }
        panel.setBackground(Color.BLACK);
        panel.add(buttonPanel, BorderLayout.CENTER);
    }

    private void styleButton(JButton button, String text) {
        if (text.matches("[0-9]") || text.equals(",")) {
            button.setBackground(Color.GRAY);
            button.setForeground(Color.WHITE);
        } else if (text.matches("[/*\\-+=]")) {
            button.setBackground(Color.ORANGE);
            button.setForeground(Color.DARK_GRAY);
        } else if (text.matches("[C%]") || text.equals("+/-")) {
            button.setBackground(Color.LIGHT_GRAY);
            button.setForeground(Color.DARK_GRAY);
            button.doClick();
        }
    }


    private void calculate(ActionEvent e) {
        String text = e.getActionCommand();
        if (text.matches("[0-9]")) {
            if (currentInput.equals("0")) {
                currentInput = text;
            } else {
                currentInput += text;
            }
            display.setText(currentInput);
        } else if (text.equals(",")) {
            if (!currentInput.contains(".")) {
                currentInput += ".";
                display.setText(currentInput);
            }
        } else if (text.matches("[/*\\-+]")) {
            if (!currentInput.isEmpty()) {
                firstOperand = Double.parseDouble(currentInput);
                operator = text;
                currentInput = "";
            }
        } else if (text.equals("=")) {
            if (!currentInput.isEmpty()) {
                double secondOperand = Double.parseDouble(currentInput);
                double result = switch (operator) {
                    case "+" -> firstOperand + secondOperand;
                    case "-" -> firstOperand - secondOperand;
                    case "*" -> firstOperand * secondOperand;
                    case "/" -> firstOperand / secondOperand;
                    default -> 0;
                };
                display.setText(String.valueOf(result));
                currentInput = "";
            }
        } else if (text.equals("C")) {
            currentInput = "0";
            display.setText("0");
        }
    }
}