package com.rmannibucau.developpez.cdi.gettingstarted;

public class Moteur {
    private String marque;
    private int puissance; // chevaux

    public float max(float vitesse) { // si trop rapide on peut limiter la vitesse ici
        return vitesse;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setPuissance(int puissance) {
        this.puissance = puissance;
    }
}