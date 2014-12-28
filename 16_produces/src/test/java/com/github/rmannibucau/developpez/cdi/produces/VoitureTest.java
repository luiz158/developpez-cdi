package com.github.rmannibucau.developpez.cdi.produces;

import org.apache.deltaspike.testcontrol.api.junit.CdiTestRunner;
import org.apache.johnzon.mapper.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import java.io.StringWriter;

import static org.junit.Assert.assertEquals;

@RunWith(CdiTestRunner.class)
public class VoitureTest {
    @Inject
    private Mapper mapper;

    @Test
    public void run() {
        Voiture voiture = new Voiture("SuperCar");

        StringWriter writer = new StringWriter();
        mapper.writeObject(voiture, writer);
        assertEquals("{\"marque\":\"SuperCar\"}", writer.toString());
    }
}
