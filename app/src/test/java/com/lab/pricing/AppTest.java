package com.lab.pricing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class AppTest {
    @Test
    void testVipCustomerWithPromo() {
        App engine = new App();
        List<OrderItem> items = List.of(new OrderItem("Product", 100.0, 1));
        double result = engine.calculateTotal(items, "VIP", "SAVE10");
        assertEquals(80.5, result, 0.001);
    }
}