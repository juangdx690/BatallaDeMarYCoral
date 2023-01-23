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
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.util.Optional;
import java.util.Random;

public class HelloController {

    private static boolean terminarJuego = false;
    int x, y;


    boolean pito = true;
    @FXML
    private Button btn;
    @FXML
    private ImageView barco1;
    @FXML
    private AnchorPane ventana;
    @FXML
    private ImageView barco2;

    Barco barco;
    Barco barcoF;


    public void initialize() {

        ImageView destructorImg = new ImageView();
        destructorImg.setImage(new Image(getClass().getResourceAsStream("images/barcoDestructorRojo.png")));
        destructorImg.setLayoutX(28);
        destructorImg.setLayoutY(371);
        barco = new Barco("destructor España", destructorImg);


        ImageView destructorImg2 = new ImageView();
        destructorImg2.setImage(new Image(getClass().getResourceAsStream("images/barcoDestructorAzul.png")));
        destructorImg2.setLayoutX(882);
        destructorImg2.setLayoutY(371);
        barcoF = new Barco("destructor Francia", destructorImg2);
        ventana.getChildren().addAll(barco.getImagenBarco(), barcoF.getImagenBarco());

    }



    @FXML
    public void hacerMovimiento(ActionEvent actionEvent) {
            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.01), (ActionEvent ae) -> {

                Movimiento.mover(barco);
                Colisiones.detectarColision(barco);
                if (Colisiones.detectarColision(barco, barcoF)) {

                    int disparo = barco.disparar();
                    System.out.println(barco.getNombre() + " dispara a:" + barcoF.getNombre() + " y le quita: " + disparo);
                    barcoF.setVida(barcoF.getVida() - disparo);

                    if (barcoF.getVida() <= 0) {

                        System.out.println("el " + barcoF.getNombre() + " muere");
                        ventana.getChildren().remove(barcoF.getImagenBarco());
                        ganador();


                    } else {
                        System.out.println("Al " + barcoF.getNombre() + " le queda: " + barcoF.getVida() + " de vida.");

                    }

                }


                Movimiento.mover(barcoF);
                Colisiones.detectarColision(barcoF);

                if (Colisiones.detectarColision(barcoF, barco)) {

                    int disparo = barcoF.disparar();
                    System.out.println(barcoF.getNombre() + " dispara a:" + barco.getNombre() + " y le quita: " + disparo);
                    barco.setVida(barco.getVida() - disparo);

                    if (barco.getVida() <= 0) {

                        System.out.println("el " + barco.getNombre() + " muere");
                        ventana.getChildren().remove(barco.getImagenBarco());


                    } else {
                        System.out.println("Al " + barco.getNombre() + " le queda: " + barco.getVida() + " de vida.");

                    }

                }


            }));
            timeline.setCycleCount(Animation.INDEFINITE);
            timeline.play();




    }



    public void ganador() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Confirmación");
        alert.setContentText("¿Estas seguro de confirmar la acción?");
        Optional<ButtonType> action = alert.showAndWait();

        if (action.get() == ButtonType.OK) {
            System.out.println("acabóo");
        } else {
            System.out.println("a");
        }
    }
}