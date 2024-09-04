package com.test;

import com.calculator.parsers.UnaryOperationParser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class UnaryOperationParserTest {

    @Test
    public void testGetOperationTextPercent() {
        String result = UnaryOperationParser.getOperationText("%", 50);
        assertEquals("0.5", result);
    }

    @Test
    public void testGetOperationTextReciprocal() {
        String result = UnaryOperationParser.getOperationText("⅟x", 4);
        assertEquals("⅟ 4.0", result);
    }

    @Test
    public void testGetOperationTextSqrt() {
        String result = UnaryOperationParser.getOperationText("√x", 9);
        assertEquals("√9.0", result);
    }

    @Test
    public void testGetOperationTextSquare() {
        String result = UnaryOperationParser.getOperationText("x²", 3);
        assertEquals("3.0²", result);
    }

    @Test
    public void testPerformOperationPercent() {
        double result = UnaryOperationParser.performOperation("%", 50);
        assertEquals(0.5, result);
    }

    @Test
    public void testPerformOperationReciprocal() {
        double result = UnaryOperationParser.performOperation("⅟x", 4);
        assertEquals(0.25, result);
    }

    @Test
    public void testPerformOperationSqrt() {
        double result = UnaryOperationParser.performOperation("√x", 9);
        assertEquals(3, result);
    }

    @Test
    public void testPerformOperationSquare() {
        double result = UnaryOperationParser.performOperation("x²", 3);
        assertEquals(9, result);
    }

    @Test
    public void testUnsupportedUnaryOperation() {
        assertThrows(UnsupportedOperationException.class, () ->
            UnaryOperationParser.performOperation("unknown", 5)
        );
    }
}
