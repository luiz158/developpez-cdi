package com.github.rmannibucau.testing;

import org.apache.deltaspike.testcontrol.api.junit.CdiTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.junit.Assert.assertNotNull;

@RunWith(CdiTestRunner.class)
public class ABeanForTheExampleTest {
    @Inject
    private ABeanForTheExample example;

    @Test
    public void run() {
        assertNotNull(example);
    }
}
