package com.rmannibucau.developpez.cdi.gettingstarted;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class VoitureTest {
    @Test
    public void run() {
        Moteur moteur = new Moteur();
        moteur.setMarque("X");
        moteur.setPuissance(100);

        Couleur couleur = new Couleur();
        couleur.setMarque("Y");
        couleur.setNuance(50);

        Voiture voiture = new Voiture();
        voiture.setMoteur(moteur);
        voiture.setCouleur(couleur);

        voiture.rouler(90);
        assertEquals(90, voiture.getVitesseActuelle(), 0.);
        assertNotNull(voiture.getCouleur());
        assertNotNull(voiture.getMoteur());
    }
}
