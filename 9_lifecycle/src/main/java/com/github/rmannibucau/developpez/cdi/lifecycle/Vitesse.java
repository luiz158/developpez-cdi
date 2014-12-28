package com.github.rmannibucau.developpez.cdi.lifecycle;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped // just a bigger scope than Voiture to hold the value in the test for demo pupose
public class Vitesse {
    private double value;

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
