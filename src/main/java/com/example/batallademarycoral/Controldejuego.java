package com.example.batallademarycoral;

import java.util.ArrayList;

class ControlDeJuego {
    ArrayList<Barco> barcos;

    public ArrayList<Barco> getBarcos() {
        return barcos;
    }

    public ControlDeJuego() {
        barcos = new ArrayList<Barco>();
    }

    public void addBarco(Barco barco) {
        barcos.add(barco);
    }


}
