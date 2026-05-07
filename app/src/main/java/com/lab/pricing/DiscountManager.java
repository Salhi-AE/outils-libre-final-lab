package com.lab.pricing;

public class DiscountManager {
    public static double getCustomerDiscountRate(String type) {
        if (type == null) return 0.0;
        return switch (type.toUpperCase()) {
            case "VIP" -> 0.20;
            case "PREMIUM" -> 0.15;
            case "REGULAR" -> 0.05;
            default -> 0.0;
        };
    }

    public static double getPromoAmount(String code) {
        if (code == null) return 0.0;
        return switch (code.toUpperCase()) {
            case "SAVE10" -> 10.0;
            case "SAVE20" -> 20.0;
            case "WELCOME" -> 5.0;
            default -> 0.0;
        };
    }
}