package com.example.batallademarycoral;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Barco {
    private String nombre;
    private int vida;
    private int velocidad;
    private int sonar;
    private int potenciaFuego;
    private ImageView imagenBarco;
    private double x;

    private double direccion;

    private Timeline moverse;

    private ArrayList<Barco> barcos;

    private int recagarDisparo;

    private String equipo;

    public Barco(String nombre, String equipo, ImageView imagenBarco, ArrayList<Barco> barcos) {
        this.nombre = nombre;
        this.imagenBarco = imagenBarco;
        this.barcos = barcos;
        this.direccion = 45;

        this.equipo = equipo;
        this.recagarDisparo = 0;
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
            sonar = 6;
            potenciaFuego = 60;
        } else if (nombre.contains("destructor")) {
            vida = 80;
            velocidad = 5;
            sonar = 15;
            potenciaFuego = 50;
        }

        moverse = new Timeline(new KeyFrame(Duration.seconds(0.05), e -> {

            acabarJuego();
            barcoMuerto();
            detectarBarcosCercanos();
            moverBarco();
            detectarParedes();


        }));
        moverse.setCycleCount(Timeline.INDEFINITE);
        moverse.play();

    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public void acabarJuego() {


        if (barcos.size() == 1) {

            moverse.stop();
            System.out.println("Ganador: " + this.getEquipo());

        }

        int barcosEspana = 0;
        int barcosFrancia = 0;
    }


    public synchronized void detectarBarcosCercanos() {

        if (recagarDisparo == 0) {
            recagarDisparo = 0;
        }

        if (recagarDisparo > 0) {

            recagarDisparo -= 1;

        }

        for (Barco barco : barcos) {
            if (barco == this) {
                continue;
            }
            double distancia = Math.sqrt(Math.pow(barco.getImagenBarco().getLayoutX() - this.getImagenBarco().getLayoutX(), 2) +
                    Math.pow(barco.getImagenBarco().getLayoutY() - this.getImagenBarco().getLayoutY(), 2));
            if (distancia < 20 && recagarDisparo == 0 && getVida() >0 && this.getEquipo() != barco.getEquipo()) {

                recagarDisparo += 30;
                int disparar = this.disparar();
                System.out.println("El barco: " + this.getNombre()+" "+ this.getEquipo() + " dispara a: " + barco.getNombre()+ " "+barco.getEquipo());
                System.out.println("Le quita: " + disparar);
                barco.setVida(barco.getVida() - disparar);
                System.out.println("Le queda de vida: " + barco.getVida());
            }
        }
    }

    public synchronized void barcoMuerto() {

        if (this.getVida() <= 0) {

            moverse.stop();

            borrarBarco();
        }

    }

    public void borrarBarco() {

        barcos.remove(barcos.indexOf(this));

    }

    public synchronized void moverBarco() {

        double x = this.getImagenBarco().getLayoutX();
        double y = this.getImagenBarco().getLayoutY();
        double velocidad = this.getVelocidad();
        double direccion = Math.toRadians(this.getDireccion());
        x += velocidad * Math.cos(direccion);
        y += velocidad * Math.sin(direccion);
        this.getImagenBarco().setLayoutX(x);
        this.getImagenBarco().setLayoutY(y);
        this.getImagenBarco().setRotate(this.getDireccion());

    }

    public synchronized void detectarParedes() {

        Colisiones.detectarColision(this);

    }


    public synchronized int disparar() {
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

    public double barcoX() {

        return imagenBarco.getLayoutX();

    }

    public double barcoY() {

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
