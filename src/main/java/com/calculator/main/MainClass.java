package com.calculator.main;

import com.calculator.icon.StageIconLoader;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class MainClass extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainClass.class.getResource("calculator-main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 470, 640);

        URL cssUrl = getClass().getResource("/styles/styles.css");
        System.out.println("CSS URL: " + cssUrl);

        stage.setTitle("Easy Calc");
        StageIconLoader.loadIcon(this, stage);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}