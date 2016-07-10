package com.thoughtworks.models;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Order {
    private Product product;
    private int count;

    public Order() {
    }

    public String getCartItemString() {
        return "名称：" + product.name() + "，数量：1" + product.unit() + "，单价：" + formatPrice(product.singleUnitPrice()) + "(元)，小计：" + formatPrice(product.singleUnitPrice()) + "(元)\n";
    }


    public void add(Product product) {
        this.product = product;
    }

    private String formatPrice(Double price){
        DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.HALF_UP);
        return df.format(price);
    }
}
