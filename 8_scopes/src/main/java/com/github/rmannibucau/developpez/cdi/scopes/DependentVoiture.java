package com.github.rmannibucau.developpez.cdi.scopes;

import javax.enterprise.context.Dependent;

@Dependent // optional it is the default
public class DependentVoiture extends Voiture {
    // with reuse equals from Object for the test
}

