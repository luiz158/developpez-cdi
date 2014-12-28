package com.github.rmannibucau.developpez.cdi.scopes;

import java.util.concurrent.atomic.AtomicInteger;

public class Voiture {
    private static final AtomicInteger ID = new AtomicInteger();

    private final int id = ID.incrementAndGet();

    public int getId() {
        return id;
    }
}
