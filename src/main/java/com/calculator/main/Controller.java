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

        String digitSelected = button.getText();
        String outputText = outputLabel.getText();

        // allow only one zero upon clicking double zero
        if (digitSelected.length() == 2 && outputText.equalsIgnoreCase("0")) {
            digitSelected = digitSelected.replaceAll("00", "0");
        }


        if (hasZeroReplaceable(outputText)) {
            // replace zero at the beginning
            outputLabel.setText(digitSelected);

            if (shouldStoreSecondNumber()) {
                secondNumberStored = true;
            }
        }
        else {
            // append to output text
            outputLabel.setText(outputText + digitSelected);
        }
    }

    private boolean hasZeroReplaceable(String text)
    {
        boolean formula = (firstNumberStored && binaryOperatorPressed && secondNumberStored);
        boolean textIsZero = Double.parseDouble(text) == 0;
        return formula || equalsOperatorPressed || unaryOperatorPressed || textIsZero;
    }

    private boolean shouldStoreSecondNumber()
    {
        return !secondNumberStored && firstNumberStored && binaryOperatorPressed;
    }
}