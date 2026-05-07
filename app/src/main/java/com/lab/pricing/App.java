package com.lab.pricing;

import java.util.List;

public class App {

    public double calculateFinalPrice(List<Double> prices, List<Integer> quantities, String customerType, String promoCode) {
        double subtotal = 0;
        for (int i = 0; i < prices.size(); i++) {
            subtotal += prices.get(i) * quantities.get(i);
        }

        double discount = 0;
        if (customerType.equals("VIP")) {
            discount = subtotal * 0.20; // خصم VIP 20%
        }

        if (promoCode.equals("SAVE10")) {
            discount += 10; // خصم ثابت
        }

        double tax = (subtotal - discount) * 0.15; // ضريبة 15%
        return subtotal - discount + tax;
    }

    public static void main(String[] args) {
        System.out.println("Pricing Engine Started...");
    }
}