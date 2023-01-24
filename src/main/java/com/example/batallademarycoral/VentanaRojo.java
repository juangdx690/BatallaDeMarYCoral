package com.example.batallademarycoral;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class VentanaRojo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("equipoRojo.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 250, 768);
        stage.setTitle("Equipo Rojo!");

        stage.setResizable(false);

        stage.setScene(scene);
        stage.show();

    }
}
