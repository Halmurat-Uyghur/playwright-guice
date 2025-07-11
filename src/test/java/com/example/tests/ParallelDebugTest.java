package com.example.tests;

import org.junit.jupiter.api.Test;
import java.util.logging.Logger;

class ParallelDebugTest extends BaseTest {
    private static final Logger logger = Logger.getLogger(ParallelDebugTest.class.getName());

    @Test
    void slowTestOne() throws InterruptedException {
        logger.info(() -> "Start slowTestOne on " + Thread.currentThread().getName());
        Thread.sleep(3000);
        logger.info(() -> "End slowTestOne on " + Thread.currentThread().getName());
    }

    @Test
    void slowTestTwo() throws InterruptedException {
        logger.info(() -> "Start slowTestTwo on " + Thread.currentThread().getName());
        Thread.sleep(3000);
        logger.info(() -> "End slowTestTwo on " + Thread.currentThread().getName());
    }
}
