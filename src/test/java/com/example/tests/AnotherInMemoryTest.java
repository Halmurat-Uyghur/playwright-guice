package com.example.tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AnotherInMemoryTest extends BaseTest {
    @Test
    void secondPageTitle() {
        page.setContent("<html><head><title>Second Page</title></head><body></body></html>");
        assertEquals("Second Page", page.title());
    }
}
