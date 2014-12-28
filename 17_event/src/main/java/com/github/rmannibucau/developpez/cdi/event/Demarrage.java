package com.github.rmannibucau.developpez.cdi.event;

import java.util.Date;

public class Demarrage {
    private double vitesse;
    private Date date = new Date();

    public Demarrage(double vitesse) {
        this.vitesse = vitesse;
    }

    public double getVitesse() {
        return vitesse;
    }

    public Date getDate() {
        return date;
    }
}
