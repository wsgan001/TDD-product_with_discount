package com.thoughtworks.models;

import com.thoughtworks.utils.PriceFormatUtil;

public class OrderItem {
    private final int defaultOrderItemCount = 1;
    private Product product;
    private int count;
    private Double itemCost;

    public OrderItem(Product product) {
        this.product = product;
        this.count = defaultOrderItemCount;
    }

    public Product getProduct() {
        return product;
    }

    public int getCount() {
        return count;
    }

    public void increaseCount() {
        this.count++;
    }

    public String getOrderItemString() {
        return "名称：" + product.name() + "，数量：" + getCount() + product.unit() + "，单价：" + PriceFormatUtil.formatPrice(product.singleUnitPrice()) + "(元)，小计：" + PriceFormatUtil.formatPrice(product.singleUnitPrice()) + "(元)\n";
    }

    public Double getItemCost() {
        return itemCost = getCount() * product.singleUnitPrice();
    }
}
