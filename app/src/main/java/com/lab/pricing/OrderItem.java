package com.lab.pricing;

public record OrderItem(String name, double price, int quantity) {
    public double getSubtotal() {
        return price * quantity;
    }
}