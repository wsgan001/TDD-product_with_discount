package com.thoughtworks.models;

public class Product {
    private final String name;
    private final String code;
    private final Double singleUnitPrice;
    private final String unit;


    public Product(String name, String code, Double singleUnitPrice, String unit) {
        this.name = name;
        this.code = code;
        this.singleUnitPrice = singleUnitPrice;
        this.unit = unit;
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


}
