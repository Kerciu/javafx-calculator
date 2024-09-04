package com.test;

import com.calculator.parsers.BinaryOperationParser;
import javafx.scene.control.Label;
import org.junit.Test;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertEquals;

public class BinaryOperationParserTest {

    @Test
    public void testAddition() {
        Label label = new Label();
        double result = BinaryOperationParser.performOperation("+", 5, 3, label);
        assertEquals(8, result);
    }

    @Test
    public void testSubtraction() {
        Label label = new Label();
        double result = BinaryOperationParser.performOperation("-", 5, 3, label);
        assertEquals(2, result);
    }

    @Test
    public void testMultiplication() {
        Label label = new Label();
        double result = BinaryOperationParser.performOperation("×", 5, 3, label);
        assertEquals(15, result);
    }

    @Test
    public void testDivision() {
        Label label = new Label();
        double result = BinaryOperationParser.performOperation("÷", 6, 3, label);
        assertEquals(2, result);
    }

    @Test
    public void testDivisionByZero() {
        Label label = new Label();
        double result = BinaryOperationParser.performOperation("÷", 5, 0, label);
        assertEquals(0, result);
        assertEquals("Error", label.getText(), "Error message should be displayed");
    }

    @Test
    public void testUnsupportedOperation() {
        Label label = new Label();
        assertThrows(UnsupportedOperationException.class, () ->
            BinaryOperationParser.performOperation("unknown", 5, 3, label)
        );
    }
}
