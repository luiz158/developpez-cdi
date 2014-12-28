package com.github.rmannibucau.developpez.cdi.interceptor;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.util.logging.Logger;

@Interceptor
@Audited
public class Auditor {
    private static Logger LOGGER = Logger.getLogger(Auditor.class.getName());

    @Inject
    private AuditStorage storage;

    @AroundInvoke
    public Object audit(InvocationContext context) throws Exception {
        LOGGER.info("Calling" + context.getMethod().getName());
        storage.getParameters().put(context.getMethod().getName(), context.getParameters());
        return context.proceed();
    }
}
