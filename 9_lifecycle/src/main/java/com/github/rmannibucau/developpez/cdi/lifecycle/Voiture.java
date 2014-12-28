package com.github.rmannibucau.developpez.cdi.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped // using a scope to be able to start/stop it and then trigger in the test demarrer/eteindre
public class Voiture {
    @Inject
    private Vitesse vitesse;

    @PostConstruct
    private void demarrer() {
        vitesse.setValue(100);
    }

    @PreDestroy
    private void eteindre() {
        vitesse.setValue(0);
    }

    public Vitesse getVitesse() {
        return vitesse;
    }
}
