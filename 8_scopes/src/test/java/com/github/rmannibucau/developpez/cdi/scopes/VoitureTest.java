package com.github.rmannibucau.developpez.cdi.scopes;

import org.apache.deltaspike.cdise.api.CdiContainerLoader;
import org.apache.deltaspike.cdise.api.ContextControl;
import org.apache.deltaspike.testcontrol.api.junit.CdiTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotSame;

@RunWith(CdiTestRunner.class)
public class VoitureTest {
    @Inject
    private DependentVoiture dependentVoiture1;

    @Inject
    private DependentVoiture dependentVoiture2;

    @Inject
    private RequestScopedVoiture requestScopedVoiture;

    @Inject
    private RequestScopedVoiture requestScopedVoiture2;

    @Inject
    private ApplicationScopedVoiture applicationScopedVoiture;

    @Test
    public void dependent() { // by injection
        assertNotSame(dependentVoiture1, dependentVoiture2);
    }

    @Test
    public void applicationScope() { // global
        assertEquals(objectInternalHashCode(applicationScopedVoiture), objectInternalHashCode(applicationScopedVoiture));
        assertNotSame(applicationScopedVoiture, objectInternalHashCode(applicationScopedVoiture)); // cause of the proxy
    }

    @Test
    public void requestScope() { // by thread
        assertEquals(requestScopedVoiture.hashCode(), requestScopedVoiture.hashCode()); // in a single thread we have a single instance
        assertEquals(requestScopedVoiture.hashCode(), requestScopedVoiture2.hashCode()); // in a single thread we have a single instance
        assertNotEquals(objectInternalHashCode(requestScopedVoiture), objectInternalHashCode(requestScopedVoiture));
    }

    // just to be able to get identify of an object from different threads
    private int objectInternalHashCode(final Voiture o) {
        final AtomicInteger hash = new AtomicInteger();
        final Thread thread1 = new Thread() {
            @Override
            public void run() {
                hash.set(o.getId());
            }
        };
        thread1.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            Thread.interrupted();
        }
        return hash.get();
    }

    private int objectInternalHashCode(final RequestScopedVoiture o) {
        final AtomicInteger hash = new AtomicInteger();
        final Thread thread1 = new Thread() {
            @Override
            public void run() {
                // start the context to avoid ContextNotActiveException
                ContextControl contextControl = CdiContainerLoader.getCdiContainer().getContextControl();
                contextControl.startContext(RequestScoped.class);

                hash.set(o.getId());

                contextControl.stopContext(RequestScoped.class);
            }
        };
        thread1.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            Thread.interrupted();
        }
        return hash.get();
    }
}
