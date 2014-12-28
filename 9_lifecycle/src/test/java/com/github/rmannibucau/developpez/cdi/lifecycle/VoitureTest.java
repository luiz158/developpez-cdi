package com.github.rmannibucau.developpez.cdi.lifecycle;

import org.apache.deltaspike.cdise.api.CdiContainerLoader;
import org.apache.deltaspike.cdise.api.ContextControl;
import org.apache.deltaspike.testcontrol.api.junit.CdiTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import static org.junit.Assert.assertEquals;

@RunWith(CdiTestRunner.class)
public class VoitureTest {
    @Inject
    private Voiture voiture;

    @Inject
    private Vitesse vitesse;

    @Test
    public void run() {
        ContextControl control = CdiContainerLoader.getCdiContainer().getContextControl();
        control.startContext(RequestScoped.class);

        assertEquals(100, voiture.getVitesse().getValue(), 0.);

        control.stopContext(RequestScoped.class);

        // here Voiture doesn't exist anymore since it is request scoped
        assertEquals(0, vitesse.getValue(), 0.);
    }
}
