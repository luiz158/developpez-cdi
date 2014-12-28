package com.github.rmannibucau.developpez.cdi.event;

import javax.enterprise.event.Event;
import javax.inject.Inject;

public class Voiture {
    @Inject
    private Event<Demarrage> demarrageEvent;

    public void rouler(double vitesse) {
        demarrageEvent.fire(new Demarrage(vitesse));
    }
}
