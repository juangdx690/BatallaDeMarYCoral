package com.example.batallademarycoral;


public class Colisiones {
    public static void detectarColision(Barco barco) {
        double x = barco.getImagenBarco().getLayoutX();
        double y = barco.getImagenBarco().getLayoutY();
        if (x < 0 || x > Costantes.ANCHO_VENTANA) {
            barco.setDireccion(180 - barco.getDireccion());
        }
        if (y < 0 || y > Costantes.ALTO_VENTANA) {
            barco.setDireccion(-barco.getDireccion());
        }
    }


    public static boolean sonarDisparo(Barco barco1, Barco barco2) {
        double distancia = distanciaEntreBarcos(barco1, barco2);
        return distancia <= barco1.getSonar();
    }
    private static double distanciaEntreBarcos(Barco barco1, Barco barco2) {
        double x1 = barco1.getImagenBarco().getLayoutX();
        double y1 = barco1.getImagenBarco().getLayoutY();
        double x2 = barco2.getImagenBarco().getLayoutX();
        double y2 = barco2.getImagenBarco().getLayoutY();
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

}