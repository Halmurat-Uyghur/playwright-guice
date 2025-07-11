package com.example.tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InMemoryPageTest extends BaseTest {
    @Test
    void titleIsReturned() {
        page.setContent("<html><head><title>My Page</title></head><body></body></html>");
        assertEquals("My Page", page.title());
    }

    @Test
    void elementIsVisible() {
        page.setContent("<html><head><title>Element</title></head><body><button id='btn'>Press</button></body></html>");
        com.example.framework.WaitUtil.waitForSelector(page, "#btn");
        assertTrue(page.isVisible("#btn"));
    }
}
