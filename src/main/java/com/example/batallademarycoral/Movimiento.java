package com.example.batallademarycoral;

public class Movimiento {
    public static void mover(Barco barco) {
        double x = barco.getImagenBarco().getLayoutX();
        double y = barco.getImagenBarco().getLayoutY();
        double velocidad = barco.getVelocidad();
        double direccion = Math.toRadians(barco.getDireccion());
        x += velocidad * Math.cos(direccion);
        y += velocidad * Math.sin(direccion);
        barco.getImagenBarco().setLayoutX(x);
        barco.getImagenBarco().setLayoutY(y);
        barco.getImagenBarco().setRotate(barco.getDireccion());




    }
}
