package com.lab.pricing;

import java.util.List;

public class App {
    private static final double TAX_RATE = 0.15;

    public double calculateTotal(List<OrderItem> items, String type, String promo) {
        double subtotal = items.stream().mapToDouble(OrderItem::getSubtotal).sum();

        double customerDiscount = subtotal * DiscountManager.getCustomerDiscountRate(type);
        double promoDiscount = DiscountManager.getPromoAmount(promo);

        double totalDiscount = customerDiscount + promoDiscount;
        double taxableAmount = Math.max(0, subtotal - totalDiscount);

        return taxableAmount + (taxableAmount * TAX_RATE);
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