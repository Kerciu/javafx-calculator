package com.example.demo;

import com.example.frontend.StageIconLoader;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 435, 560);

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