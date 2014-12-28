package com.rmannibucau.developpez.cdi.qualifiers;

import javax.inject.Inject;

public class Voiture {
    @Inject
    @Marque1
    private Moteur moteur;

    public Moteur getMoteur() {
        return moteur;
    }
}

