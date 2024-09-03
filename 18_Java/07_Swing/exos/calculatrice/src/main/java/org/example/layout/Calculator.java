package org.example.layout;

import lombok.Data;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

@Data
public class Calculator {
    private JTextField display;
    private JPanel panel;
    private String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "C", "=", "+"
    };
    private String currentInput = "";
    private String operator = "";
    private double firstOperand = 0;

    public Calculator() {
        display = new JTextField();
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setFont(new Font("Arial", Font.BOLD, 20));

        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 20));
            button.addActionListener(this::calculate);
            panel.add(button);
        }
    }

    private void calculate(ActionEvent e){
        String text = e.getActionCommand();
        if (text.matches("[0-9]")) {
            currentInput += text;
            display.setText(currentInput);
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
            currentInput = "";
            display.setText("");
        }
    }
}
