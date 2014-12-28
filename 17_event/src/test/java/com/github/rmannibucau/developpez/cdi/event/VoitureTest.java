package com.github.rmannibucau.developpez.cdi.event;

import org.apache.deltaspike.testcontrol.api.junit.CdiTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;

@RunWith(CdiTestRunner.class)
public class VoitureTest {
    @Inject
    private Voiture voiture;

    @Inject
    private DemarrageListener listener;

    @Test
    public void run() {
        assertEquals(0, listener.getDemarrages().size());

        voiture.rouler(100);
        assertEquals(1, listener.getDemarrages().size());
        assertEquals(100, listener.getDemarrages().get(0).getVitesse(), 0.);

        voiture.rouler(200);
        assertEquals(2, listener.getDemarrages().size());
        assertEquals(200, listener.getDemarrages().get(1).getVitesse(), 0.);
    }
}
