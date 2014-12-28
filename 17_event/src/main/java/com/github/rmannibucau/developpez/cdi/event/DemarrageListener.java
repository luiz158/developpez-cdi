package com.github.rmannibucau.developpez.cdi.event;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class DemarrageListener {
    private List<Demarrage> demarrages = new ArrayList<Demarrage>();

    public void observeDemarrage(@Observes Demarrage demarrage) {
        demarrages.add(demarrage);
    }

    public List<Demarrage> getDemarrages() {
        return demarrages;
    }
}
