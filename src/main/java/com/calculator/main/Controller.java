package com.calculator.main;

import com.calculator.performer.UnaryOperationParser;
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

    @FXML
    public void handleNumberSelected(ActionEvent evt)
    {
        Button button = (Button) evt.getSource();

        String digitSelected = button.getText();
        String outputText = outputLabel.getText();

        parseDoubleZeroAtBeginning(digitSelected);


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

    @FXML
    public void handleUnaryOperator(ActionEvent evt)
    {
        Button button = (Button) evt.getSource();
        String unaryOperator = button.getText();

        firstNumber = Double.parseDouble(outputLabel.getText());
        firstNumberStored = true;

        String operation = UnaryOperationParser.getOperationText(unaryOperator, firstNumber);
        inputLabel.setText(operation);

        firstNumber = UnaryOperationParser.performOperation(unaryOperator, firstNumber);
        outputLabel.setText(Double.toString(firstNumber));

        unaryOperatorPressed = true;
        binaryOperatorPressed = false;
        equalsOperatorPressed = false;
        firstNumberStored = true;
    }

    @FXML
    public void handleBinaryOperator(ActionEvent evt)
    {
        Button button = (Button) evt.getSource();
        String binaryOperator = button.getText();

        if (!firstNumberStored) {
            firstNumber = Double.parseDouble(outputLabel.getText());
            firstNumberStored = true;
        }

        if (firstNumberStored) updateBinaryOperator(binaryOperator);

        binaryOperatorPressed = true;
        unaryOperatorPressed = false;
        equalsOperatorPressed = false;
        firstNumberStored = true;
    }

    @FXML
    public void handleDotButton()
    {
        if (!outputLabel.getText().contains(".")) {
            outputLabel.setText(outputLabel.getText() + ".");
        }
    }

    @FXML
    public void handleClearEntryButton()
    {

    }

    @FXML
    public void handleClearButton()
    {

    }

    @FXML
    public void handleDeleteButton()
    {

    }

    private void updateBinaryOperator(String binaryOperator)
    {
        this.binaryOperator = binaryOperator;
        inputLabel.setText(firstNumber + " " + binaryOperator);
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

    private void parseDoubleZeroAtBeginning(String digitSelected)
    {
        if (digitSelected.length() == 2 && outputLabel.getText().equalsIgnoreCase("0")) {
            digitSelected = digitSelected.replaceAll("00", "0");
        }
    }
}