package com.lab.pricing;

import java.util.List;

public class App {

    public double calculateTotal(List<OrderItem> items, String customerType, String promoCode) {
        double subtotal = items.stream()
                .mapToDouble(OrderItem::getSubtotal)
                .sum();
        double discount = getCustomerDiscount(subtotal, customerType) + getPromoDiscount(promoCode);
        double tax = (subtotal - discount) * 0.15;
        return subtotal - discount + tax;
    }

    private double getCustomerDiscount(double subtotal, String type) {
        if ("VIP".equalsIgnoreCase(type)) return subtotal * 0.20;
        return 0;
    }

    private double getPromoDiscount(String code) {
        if ("SAVE10".equalsIgnoreCase(code)) return 10.0;
        return 0;
    }

    public static void main(String[] args) {
        App engine = new App();
        List<OrderItem> cart = List.of(
                new OrderItem("Laptop", 1000.0, 1),
                new OrderItem("Mouse", 50.0, 2)
        );

        double finalPrice = engine.calculateTotal(cart, "VIP", "SAVE10");
        System.out.println("Final Price for VIP with SAVE10: " + finalPrice);
    }
}