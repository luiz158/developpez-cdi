package com.rmannibucau.developpez.cdi.gettingstarted;

import javax.inject.Inject;

public class Voiture {
    @Inject
    private Moteur moteur;

    @Inject
    private Couleur couleur;

    private float vitesseActuelle; // km/h

    public void rouler(final float vitesse) {
        vitesseActuelle = vitesse;
    }

    public void freiner() {
        vitesseActuelle = vitesseActuelle * 0.8f;
    }

    public float getVitesseActuelle() {
        return vitesseActuelle;
    }

    public void setMoteur(Moteur moteur) {
        this.moteur = moteur;
    }

    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }

    public Moteur getMoteur() {
        return moteur;
    }

    public Couleur getCouleur() {
        return couleur;
    }
}

