package com.example.batallademarycoral;

public class Rotacion {
    public static void rotar(Barco barco, double grados) {
        barco.getImagenBarco().setRotate(barco.getImagenBarco() .getRotate() + grados);
    }
}