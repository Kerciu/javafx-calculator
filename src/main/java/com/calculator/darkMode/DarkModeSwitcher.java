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

            inputLabel.setStyle("-fx-background-color: #333333; -fx-effect: dropshadow(gaussian, rgba(255, 255, 255, 0.2), 5, 0, 2, 2);");
            outputLabel.setStyle("-fx-background-color: #333333; -fx-text-fill: #bbbbbb; -fx-effect: dropshadow(gaussian, rgba(255, 255, 255, 0.2), 5, 0, 2, 2);");

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

            inputLabel.setStyle("-fx-background-color: #ffffff; -fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.1), 5, 0, 2, 2);");
            outputLabel.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #0a7bff; -fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.1), 5, 0, 2, 2);");

            for (Node node : toggleSwitchContainer.getChildren()) {
                if (node instanceof Button) {
                    node.setStyle("-fx-background-color: linear-gradient(to bottom, #ffffff, #e0eafc); -fx-text-fill: #4a90e2;");
                }
            }
        }
    }
}
