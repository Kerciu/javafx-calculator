package com.calculator.darkMode;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;


public class DarkModeSwitcher {
    public static void enableDarkMode(Label inputLabel, Label outputLabel, AnchorPane toggleSwitchContainer)
    {
        Scene scene = toggleSwitchContainer.getScene();
        if (scene != null) {
            scene.getRoot().setStyle("-fx-background-color: linear-gradient(to bottom right, #333333, #444444);");

            inputLabel.getStyleClass().remove("input-label-light");
            inputLabel.getStyleClass().add("input-label-dark");

            outputLabel.getStyleClass().remove("output-label-light");
            outputLabel.getStyleClass().add("output-label-dark");

            for (Node node : toggleSwitchContainer.getChildren()) {
                if (node instanceof Button) {
                    node.setStyle("-fx-background-color: linear-gradient(to bottom, #333333, #444444); -fx-text-fill: #dddddd;");
                }
            }
        }
    }

    public static void enableLightMode(Label inputLabel, Label outputLabel, AnchorPane toggleSwitchContainer) {
        Scene scene = toggleSwitchContainer.getScene();
        if (scene != null) {
            scene.getRoot().setStyle("-fx-background-color: linear-gradient(to bottom right, #f8f9fc, #e0eafc);");

            inputLabel.getStyleClass().remove("input-label-dark");
            inputLabel.getStyleClass().add("input-label-light");

            outputLabel.getStyleClass().remove("output-label-dark");
            outputLabel.getStyleClass().add("output-label-light");

            for (Node node : toggleSwitchContainer.getChildren()) {
                if (node instanceof Button) {
                    node.setStyle("-fx-background-color: linear-gradient(to bottom, #ffffff, #e0eafc); -fx-text-fill: #4a90e2;");
                }
            }
        }
    }
}
