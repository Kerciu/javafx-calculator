package com.calculator.main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {
    @FXML
    public Label inputLabel;

    @FXML
    public Label outputLabel;

    private boolean binaryOperatorPressed, unaryOperatorPressed, equalsOperatorPressed;
    private boolean firstNumberStored, secondNumberStored;

    private double firstNumber, secondNumber;
    private String binaryOperator;

    public void handleNumberSelected(ActionEvent evt)
    {
        Button button = (Button) evt.getSource();

        boolean doubleZeroSelected = false;
        String digitSelected = button.getText();
        if (digitSelected.length() == 2) doubleZeroSelected = true;

        String outputText = outputLabel.getText();

        if (hasZeroReplaceable(outputText)) {
            // replace zero at the beginning
        }
        else {
            // append to output text
        }
    }

    private boolean hasZeroReplaceable(String text)
    {
        boolean formula = (firstNumberStored && binaryOperatorPressed && secondNumberStored);
        boolean textIsZero = Double.parseDouble(text) == 0;
        return formula || equalsOperatorPressed || unaryOperatorPressed || textIsZero;
    }
}