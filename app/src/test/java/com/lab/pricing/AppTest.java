package com.lab.pricing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class AppTest {
    @Test
    void testCalculateFinalPriceForVIP() {
        App app = new App();
        double result = app.calculateFinalPrice(List.of(100.0), List.of(1), "VIP", "NONE");
        assertEquals(92.0, result);
    }
}