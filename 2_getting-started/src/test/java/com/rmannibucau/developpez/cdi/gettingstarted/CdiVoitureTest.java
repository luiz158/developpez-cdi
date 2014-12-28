package com.rmannibucau.developpez.cdi.gettingstarted;

import org.apache.deltaspike.testcontrol.api.junit.CdiTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(CdiTestRunner.class)
public class CdiVoitureTest {
    @Inject
    private Voiture voiture;

    @Test
    public void run() {
        voiture.rouler(90);
        assertEquals(90, voiture.getVitesseActuelle(), 0.);
        assertNotNull(voiture.getCouleur());
        assertNotNull(voiture.getMoteur());
    }
}
