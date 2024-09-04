package com.calculator.performer;

import com.calculator.constants.OperatorConstants;

public class UnaryOperationParser {
    public static String getOperationText(String operator, double number)
    {
        return switch (OperatorConstants.parseUnaryOperator(operator))
        {
            case PERCENT -> {
                number /= 100;
                yield Double.toString(number);
            }

            case RECIPROCAL -> "⅟ " + number;

            case SQRT -> "√" + number;

            case SQUARE -> number + "²";

            default -> throw new RuntimeException("No such operator exists");
        };
    }

    public static double performOperation(String operator, double number)
    {
        return switch (OperatorConstants.parseUnaryOperator(operator))
        {
            case PERCENT -> {
                number /= 100;
                yield number;
            }

            case RECIPROCAL -> 1 / number;

            case SQRT -> Math.sqrt(number);

            case SQUARE -> number * number;

            default -> throw new RuntimeException("No such operator exists");
        };
    }
}
