package com.lab.pricing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class AppTest {
    App engine = new App();

    @Test
    @DisplayName("Testing the status of a regular customer without a discount code")
    void testRegularCustomerNoPromo() {
        List<OrderItem> items = List.of(new OrderItem("Book", 100.0, 1));
        assertEquals(109.25, engine.calculateTotal(items, "REGULAR", "NONE"), 0.01);
    }

    @Test
    @DisplayName("Testing the large discount that could make the price negative (it should remain 0)")
    void testExtremeDiscount() {
        List<OrderItem> items = List.of(new OrderItem("Pen", 5.0, 1));
        assertEquals(0.0, engine.calculateTotal(items, "REGULAR", "SAVE20"), 0.01);
    }

    @Test
    @DisplayName("Testing an empty shopping list")
    void testEmptyCart() {
        assertEquals(0.0, engine.calculateTotal(List.of(), "VIP", "SAVE10"), 0.01);
    }

    @Test
    @DisplayName("Test empty input (Null Safety)")
    void testNullInputs() {
        List<OrderItem> items = List.of(new OrderItem("Product", 100.0, 1));
        assertDoesNotThrow(() -> engine.calculateTotal(items, null, null));
    }
}