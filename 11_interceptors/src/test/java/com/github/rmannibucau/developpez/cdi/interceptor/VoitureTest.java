package com.github.rmannibucau.developpez.cdi.interceptor;

import org.apache.deltaspike.testcontrol.api.junit.CdiTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(CdiTestRunner.class)
public class VoitureTest {
    @Inject
    private Voiture voiture;

    @Inject
    private AuditStorage storage;

    @Test
    public void roule() {
        voiture.rouler(100);

        assertEquals(1, storage.getParameters().size());
        assertNotNull(storage.getParameters().get("rouler"));
        assertEquals(1, storage.getParameters().get("rouler").length);
        assertEquals(100., storage.getParameters().get("rouler")[0]);
    }
}
