package com.calculator.darkMode;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;


public class DarkModeSwitcher {
    public static void enableDarkMode(Label inputLabel, Label outputLabel, AnchorPane toggleSwitchContainer, GridPane gridPane)
    {
        Scene scene = toggleSwitchContainer.getScene();
        if (scene != null) {
            scene.getRoot().setStyle("-fx-background-color: linear-gradient(to bottom right, #333333, #444444);");

            inputLabel.getStyleClass().remove("input-label-light");
            inputLabel.getStyleClass().add("input-label-dark");

            outputLabel.getStyleClass().remove("output-label-light");
            outputLabel.getStyleClass().add("output-label-dark");

            addButtonStyles(gridPane, "button", true);
            addButtonStyles(gridPane, "calculation-btn", true);
        }
    }

    public static void enableLightMode(Label inputLabel, Label outputLabel, AnchorPane toggleSwitchContainer, GridPane gridPane) {
        Scene scene = toggleSwitchContainer.getScene();
        if (scene != null) {
            scene.getRoot().setStyle("-fx-background-color: linear-gradient(to bottom right, #f8f9fc, #e0eafc);");

            inputLabel.getStyleClass().remove("input-label-dark");
            inputLabel.getStyleClass().add("input-label-light");

            outputLabel.getStyleClass().remove("output-label-dark");
            outputLabel.getStyleClass().add("output-label-light");

            addButtonStyles(gridPane, "button", false);
            addButtonStyles(gridPane, "calculation-btn", false);
        }
    }

    private static void addButtonStyles(GridPane buttonGridPane, String buttonType, boolean toDark) {
        buttonGridPane.lookupAll(toDark ? "."+buttonType+"-light" : "."+buttonType+"-dark").forEach(node -> {
            if (node instanceof Button) {
                Button button = (Button) node;

                if (toDark) {
                    button.getStyleClass().add(buttonType+"-dark");
                    button.getStyleClass().remove(buttonType+"-light");
                } else {
                    button.getStyleClass().add(buttonType+"-light");
                    button.getStyleClass().remove(buttonType+"-dark");
                }
            }
        });
    }
}
