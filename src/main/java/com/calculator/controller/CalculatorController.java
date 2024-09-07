package com.calculator.controller;

import com.calculator.darkMode.DarkModeSwitcher;
import com.calculator.darkMode.ToggleSwitch;
import com.calculator.parsers.BinaryOperationParser;
import com.calculator.state.CalculatorState;
import com.calculator.parsers.UnaryOperationParser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class CalculatorController {

    private CalculatorState calculatorState = new CalculatorState();

    @FXML
    public AnchorPane toggleSwitchContainer;

    @FXML
    public Label inputLabel;

    @FXML
    public Label outputLabel;

    @FXML
    public GridPane buttonGridPane;

    @FXML
    public void initialize()
    {
        inputLabel.getStyleClass().add("input-label-light");
        outputLabel.getStyleClass().add("output-label-light");

        ToggleSwitch toggleSwitch = new ToggleSwitch(60, 30);

        toggleSwitch.addSwitchedOnProperty(
                this::enableDarkMode,
                this::enableLightMode
        );

        toggleSwitchContainer.getChildren().add(toggleSwitch);
    }

    @FXML
    public void handleNumberSelected(ActionEvent evt)
    {
        Button button = (Button) evt.getSource();
        String digitSelected = button.getText();
        digitSelected = parseDoubleZeroIfClicked(digitSelected);

        if (shouldReplaceOutput()) {
            outputLabel.setText(digitSelected);
            calculatorState.setUnaryOperatorPressed(false);
        } else {
            outputLabel.setText(outputLabel.getText() + digitSelected);
        }

        if (calculatorState.isBinaryOperatorPressed()) {
            calculatorState.setSecondNumber(Double.parseDouble(outputLabel.getText()));
        }

        if (calculatorState.isAwaitingSecondNumber()) calculatorState.setAwaitingSecondNumber(false);
    }

    @FXML
    public void handleUnaryOperator(ActionEvent evt)
    {
        Button button = (Button) evt.getSource();
        String unaryOperator = button.getText();

        double number = Double.parseDouble(outputLabel.getText());

        String operation = UnaryOperationParser.getOperationText(unaryOperator, number);
        inputLabel.setText(operation);

        double result = UnaryOperationParser.performOperation(unaryOperator, number);
        outputLabel.setText(Double.toString(result));

        calculatorState.resetState();
        calculatorState.setUnaryOperatorPressed(true);

        if (!calculatorState.isFirstNumberStored()) calculatorState.setFirstNumber(result);
        else if (shouldStoreUnary()) calculatorState.setSecondNumber(result);
    }

    @FXML
    public void handleBinaryOperator(ActionEvent evt)
    {
        Button button = (Button) evt.getSource();
        String binaryOperator = button.getText();

        if (!calculatorState.isBinaryOperatorPressed()) {
            calculatorState.setFirstNumber(Double.parseDouble(outputLabel.getText()));
        }

        calculatorState.setBinaryOperator(binaryOperator);
        inputLabel.setText(calculatorState.getFirstNumber() + " " + binaryOperator);

        calculatorState.setAwaitingSecondNumber(true);
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
        outputLabel.setText("0");
    }

    @FXML
    public void handleClearButton()
    {
        outputLabel.setText("0");
        inputLabel.setText("");
        calculatorState.resetState();
    }

    @FXML
    public void handleDeleteButton()
    {
        if (!outputLabel.getText().equalsIgnoreCase("0"))
        {
            outputLabel.setText(outputLabel.getText().substring(0, outputLabel.getText().length() - 1));
        }

        if (outputLabel.getText().length() <= 0)
        {
            outputLabel.setText("0");
        }
    }

    @FXML
    public void handleEqualsButton()
    {
        if (calculatorState.isBinaryOperatorPressed())
        {
            if (!calculatorState.isSecondNumberStored()) {
                calculatorState.setSecondNumber(Double.parseDouble(outputLabel.getText()));
            }
            double result = BinaryOperationParser.performOperation(
                calculatorState.getBinaryOperator(),
                calculatorState.getFirstNumber(),
                calculatorState.getSecondNumber(),
                outputLabel
            );

            outputLabel.setText(Double.toString(result));
            inputLabel.setText(calculatorState.getFirstNumber() + " " + calculatorState.getBinaryOperator() + " " + calculatorState.getSecondNumber() + " = ");

            calculatorState.resetState();
            calculatorState.setFirstNumber(result);
        }
    }

    private void enableDarkMode() {
        DarkModeSwitcher.enableDarkMode(inputLabel, outputLabel, toggleSwitchContainer, buttonGridPane);
    }

    private void enableLightMode() {
        DarkModeSwitcher.enableLightMode(inputLabel, outputLabel, toggleSwitchContainer, buttonGridPane);
    }

    private boolean shouldReplaceOutput()
    {
        boolean textEqualsZero = outputLabel.getText().equalsIgnoreCase("0");
        boolean textEqualsDoubleZero = outputLabel.getText().equalsIgnoreCase("00");
        boolean unaryPressed = calculatorState.isUnaryOperatorPressed();
        boolean awaitingSecondNumber = calculatorState.isAwaitingSecondNumber();

        return textEqualsZero || textEqualsDoubleZero || unaryPressed || awaitingSecondNumber;
    }

    private String parseDoubleZeroIfClicked(String digits)
    {
        return digits.equalsIgnoreCase("00") && outputLabel.getText().equalsIgnoreCase("0") ? "0" : digits;
    }

    private boolean shouldStoreUnary() {
        return calculatorState.isBinaryOperatorPressed() && !calculatorState.isAwaitingSecondNumber();
    }
}