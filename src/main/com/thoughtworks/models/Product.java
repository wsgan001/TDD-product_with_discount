package com.thoughtworks.models;

public class Product {
    private final String name;
    private final String code;
    private final Double singleUnitPrice;
    private final String unit;
    private final double discount;


    public Product(String name, String code, Double singleUnitPrice, String unit, double percentage) {
        this.name = name;
        this.code = code;
        this.singleUnitPrice = singleUnitPrice;
        this.unit = unit;
        this.discount= percentage;
    }

    public static Product buildDiscountProduct(String productCode, String name, double price, String unit, double percentage) {
        return new Product(name, productCode, price, unit, percentage);
    }

    public static Product buildNormalProduct(String productCode, String name, double price, String unit) {
        return new Product(name, productCode, price, unit, 1.0);
    }

    public Double singleUnitPrice() {
        return singleUnitPrice;
    }

    public String name() {
        return name;
    }

    public String unit() {
        return unit;
    }

    public String code() {
        return code;
    }

    public double getDiscount() {
        return discount;
    }
}
