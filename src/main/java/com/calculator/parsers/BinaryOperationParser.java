package com.calculator.parsers;

import javafx.scene.control.Label;

public class BinaryOperationParser {
    public static double performOperation(String operator, double firstNumber, double secondNumber, Label outputLabel)
    {
        return switch (operator)
        {
            case "+" -> firstNumber + secondNumber;
            case "-" -> firstNumber - secondNumber;
            case "×" -> firstNumber * secondNumber;
            case "÷" -> {
                if (secondNumber != 0) {
                    yield firstNumber / secondNumber;
                } else {
                    outputLabel.setText("Error");
                    yield 0;
                }
            }
            default -> throw new UnsupportedOperationException("Unsupported operator: " + operator);
        };
    }
}
