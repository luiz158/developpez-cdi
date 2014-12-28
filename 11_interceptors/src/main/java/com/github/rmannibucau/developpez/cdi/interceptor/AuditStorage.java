package com.github.rmannibucau.developpez.cdi.interceptor;

import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class AuditStorage {
    private Map<String, Object[]> parameters = new HashMap<String, Object[]>();

    public Map<String, Object[]> getParameters() {
        return parameters;
    }
}
