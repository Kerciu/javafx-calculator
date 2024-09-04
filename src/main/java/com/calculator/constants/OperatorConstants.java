package com.calculator.constants;

public class OperatorConstants {
    public static enum UnaryOperation { PERCENT, RECIPROCAL, SQUARE, SQRT, UNKNOWN }
    public static enum BinaryOperation { ADDITION , SUBTRACTION , MULTIPLICATION , DIVISION, UNKNOWN}

    public static UnaryOperation parseUnaryOperator(String operator)
    {
        return switch (operator) {
            case "%" -> UnaryOperation.PERCENT;
            case "⅟x" -> UnaryOperation.RECIPROCAL;
            case "x²" -> UnaryOperation.SQUARE;
            case "√x" -> UnaryOperation.SQRT;
            default -> UnaryOperation.UNKNOWN;
        };
    }

    public static BinaryOperation parseBinaryOperator(String operator)
    {
        return switch (operator) {
            case "÷" -> BinaryOperation.DIVISION;
            case "×" -> BinaryOperation.MULTIPLICATION;
            case "-" -> BinaryOperation.SUBTRACTION;
            case "+" -> BinaryOperation.ADDITION;
            default -> BinaryOperation.UNKNOWN;
        };
    }
}
