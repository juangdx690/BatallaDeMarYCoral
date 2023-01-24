package com.example.batallademarycoral;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

public class HelloController {

    private static boolean terminarJuego = false;
    int x, y;


    boolean pito = true;
    @FXML
    private AnchorPane ventana;

    Barco barcoDesEsp;
    Barco barcoLanEsp;
    Barco barcoAcoEsp;
    Barco barcoSubEsp;
    Barco barcoDesFr;
    Barco barcoLanFr;
    Barco barcoAcoFr;
    Barco barcoSubFr;
    ControlDeJuego control;
    private Image fondo;

    public void initialize() {

        Image fondo = new Image(getClass().getResourceAsStream("images/background.png"));
        ImageView back = new ImageView(fondo);


        ventana.setBackground(new Background(new BackgroundImage(back.getImage(), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));

        ventanaEquipoAzul();
        ventanaEquipoRojo();

        instanciarBarcos();


    }

    public void ventanaEquipoRojo()  {

        Stage stage = new Stage();

        VentanaRojo ventanaRojo = new VentanaRojo();

        try {
            ventanaRojo.start(stage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void ventanaEquipoAzul()  {

        Stage stage = new Stage();

        VentanaAzul ventanaAzul = new VentanaAzul();

        try {
            ventanaAzul.start(stage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public void instanciarBarcos() {

        control = new ControlDeJuego();

        ImageView destructorImg = new ImageView();
        destructorImg.setImage(new Image(getClass().getResourceAsStream("images/barcoDestructorRojo.png")));
        destructorImg.setLayoutX(28);
        destructorImg.setLayoutY(371);
        control.addBarco(barcoDesEsp = new Barco("destructor", "España", destructorImg, control.getBarcos()));

        ImageView acorazadoImg = new ImageView();
        acorazadoImg.setImage(new Image(getClass().getResourceAsStream("images/barcoDestructorRojo.png")));
        acorazadoImg.setLayoutX(28);
        acorazadoImg.setLayoutY(75);
        control.addBarco(barcoAcoEsp = new Barco("acorazado", "España", acorazadoImg, control.getBarcos()));

        ImageView lanchaImg = new ImageView();
        lanchaImg.setImage(new Image(getClass().getResourceAsStream("images/barcoDestructorRojo.png")));
        lanchaImg.setLayoutX(28);
        lanchaImg.setLayoutY(149);
        control.addBarco(barcoLanEsp = new Barco("lancha", "España", lanchaImg, control.getBarcos()));

        ImageView submarinoImg = new ImageView();
        submarinoImg.setImage(new Image(getClass().getResourceAsStream("images/barcoDestructorRojo.png")));
        submarinoImg.setLayoutX(28);
        submarinoImg.setLayoutY(575);
        control.addBarco(barcoSubEsp = new Barco("submarino", "España", submarinoImg, control.getBarcos()));


        ImageView destructorImg2 = new ImageView();
        destructorImg2.setImage(new Image(getClass().getResourceAsStream("images/barcoDestructorAzul.png")));
        destructorImg2.setLayoutX(882);
        destructorImg2.setLayoutY(371);
        control.addBarco(barcoDesFr = new Barco("destructor", "Francia", destructorImg2, control.getBarcos()));


        ImageView acorazadoImg2 = new ImageView();
        acorazadoImg2.setImage(new Image(getClass().getResourceAsStream("images/barcoDestructorAzul.png")));
        acorazadoImg2.setLayoutX(876);
        acorazadoImg2.setLayoutY(75);
        control.addBarco(barcoAcoFr = new Barco("acorazado", "Francia", acorazadoImg2, control.getBarcos()));

        ImageView lanchaImg2 = new ImageView();
        lanchaImg2.setImage(new Image(getClass().getResourceAsStream("images/barcoDestructorAzul.png")));
        lanchaImg2.setLayoutX(876);
        lanchaImg2.setLayoutY(147);
        control.addBarco(barcoLanFr = new Barco("lancha", "Francia", lanchaImg2, control.getBarcos()));


        ImageView submarinoImg2 = new ImageView();
        submarinoImg2.setImage(new Image(getClass().getResourceAsStream("images/barcoDestructorAzul.png")));
        submarinoImg2.setLayoutX(876);
        submarinoImg2.setLayoutY(575);
        control.addBarco(barcoSubFr = new Barco("submarino", "Francia", submarinoImg2, control.getBarcos()));

        ventana.getChildren().addAll(barcoDesEsp.getImagenBarco(), barcoDesFr.getImagenBarco(), barcoAcoEsp.getImagenBarco(), barcoAcoFr.getImagenBarco(),
                barcoLanEsp.getImagenBarco(), barcoLanFr.getImagenBarco(), barcoSubEsp.getImagenBarco(), barcoSubFr.getImagenBarco());


    }


    public void ganador() {
    }
}