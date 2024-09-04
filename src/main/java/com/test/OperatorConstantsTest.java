package com.test;

import static org.junit.Assert.assertEquals;

import com.calculator.constants.OperatorConstants;
import org.junit.Test;

public class OperatorConstantsTest {

    @Test
    public void testParseUnaryOperator() {
        assertEquals(OperatorConstants.UnaryOperation.PERCENT, OperatorConstants.parseUnaryOperator("%"));
        assertEquals(OperatorConstants.UnaryOperation.RECIPROCAL, OperatorConstants.parseUnaryOperator("⅟x"));
        assertEquals(OperatorConstants.UnaryOperation.SQUARE, OperatorConstants.parseUnaryOperator("x²"));
        assertEquals(OperatorConstants.UnaryOperation.SQRT, OperatorConstants.parseUnaryOperator("√x"));
        assertEquals(OperatorConstants.UnaryOperation.UNKNOWN, OperatorConstants.parseUnaryOperator("unknown"));
    }

    @Test
    public void testParseBinaryOperator() {
        assertEquals(OperatorConstants.BinaryOperation.ADDITION, OperatorConstants.parseBinaryOperator("+"));
        assertEquals(OperatorConstants.BinaryOperation.SUBTRACTION, OperatorConstants.parseBinaryOperator("-"));
        assertEquals(OperatorConstants.BinaryOperation.MULTIPLICATION, OperatorConstants.parseBinaryOperator("×"));
        assertEquals(OperatorConstants.BinaryOperation.DIVISION, OperatorConstants.parseBinaryOperator("÷"));
        assertEquals(OperatorConstants.BinaryOperation.UNKNOWN, OperatorConstants.parseBinaryOperator("unknown"));
    }
}

