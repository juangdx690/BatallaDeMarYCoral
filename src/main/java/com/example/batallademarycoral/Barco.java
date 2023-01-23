package com.example.batallademarycoral;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.Random;

public class Barco {

    private Timeline timeline;
    private String nombre;
    private int vida;
    private int velocidad;
    private int sonar;
    private int potenciaFuego;
    private ImageView imagenBarco;
    private double x;

    private double direccion;

    public Barco(String nombre, ImageView imagenBarco) {
        this.nombre = nombre;
        this.imagenBarco = imagenBarco;

        this.direccion = 45;

        imagenBarco.setFitHeight(50);
        imagenBarco.setFitWidth(50);

        if (nombre.contains("lancha")) {
            vida = 10;
            velocidad = 10;
            sonar = 12;
            potenciaFuego = 20;
        } else if (nombre.contains("acorazado")) {
            vida = 120;
            velocidad = 3;
            sonar = 30;
            potenciaFuego = 80;
        } else if (nombre.contains("submarino")) {
            vida = 30;
            velocidad = 2;
            potenciaFuego = 60;
        } else if (nombre.contains("destructor")) {
            vida = 80;
            velocidad = 5;
            sonar = 15;
            potenciaFuego = 50;
        }


    }

    public int disparar() {
        Random rand = new Random();
        int random = rand.nextInt(101);
        if (random < 25) {
            return 0;
        } else if (random < 50) {
            return potenciaFuego / 2;
        } else {
            return potenciaFuego;
        }
    }

    public double getDireccion() {
        return direccion;
    }

    public void setDireccion(double direccion) {
        this.direccion = direccion;
    }

    public ImageView getImagenBarco() {
        return imagenBarco;
    }

    public double barcoX(){

        return imagenBarco.getLayoutX();

    }

    public double barcoY(){

        return imagenBarco.getLayoutY();
    }

    public void moverBarco(double posX, double posY) {
        imagenBarco.setLayoutX(posX);
        imagenBarco.setLayoutY(posY);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getSonar() {
        return sonar;
    }

    public void setSonar(int sonar) {
        this.sonar = sonar;
    }

    public int getPotenciaFuego() {
        return potenciaFuego;
    }

    public void setPotenciaFuego(int potenciaFuego) {
        this.potenciaFuego = potenciaFuego;
    }
}
