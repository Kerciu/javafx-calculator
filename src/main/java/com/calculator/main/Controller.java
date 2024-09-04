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

    public void handleNumberSelected(ActionEvent evt)
    {
        Button button = (Button) evt.getSource();

        String digitSelected = button.getText();
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
        return false;
    }
}