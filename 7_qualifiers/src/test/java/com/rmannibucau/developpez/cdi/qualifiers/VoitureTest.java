package com.rmannibucau.developpez.cdi.qualifiers;

import org.apache.deltaspike.testcontrol.api.junit.CdiTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(CdiTestRunner.class)
public class VoitureTest {
    @Inject
    private Moteur moteur;

    @Inject
    @Marque1
    private MoteurDeMarque1 moteurDeMarque1;

    @Inject
    private Voiture voiture;

    @Test
    public void voiture() {
        assertEquals("Marque 1", voiture.getMoteur().getMarque());
    }

    @Test
    public void moteurs() {
        assertNotEquals(moteur.getMarque(), moteurDeMarque1.getMarque());
    }
}
