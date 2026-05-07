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
        if (args.length < 4) {
            System.out.println("Usage: <Price> <Qty> <CustomerType> <Promo>");
            return;
        }

        App engine = new App();
        double price = Double.parseDouble(args[0]);
        int qty = Integer.parseInt(args[1]);
        String type = args[2];
        String promo = args[3];

        List<OrderItem> cart = List.of(new OrderItem("Product", price, qty));
        System.out.println(engine.calculateTotal(cart, type, promo));
    }
}