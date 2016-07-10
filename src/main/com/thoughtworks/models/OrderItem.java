package com.thoughtworks.models;

import com.thoughtworks.utils.PriceFormatUtil;

public class OrderItem {
    private final int defaultOrderItemCount = 1;
    private Product product;
    private int count;

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
        String result = "名称：" + product.name() + "，数量：" + getCount() + product.unit() + "，单价：" + PriceFormatUtil.formatPrice(product.singleUnitPrice()) + "(元)，小计：" + PriceFormatUtil.formatPrice(product.singleUnitPrice() * product.getDiscount()) + "(元)";
        if (product.getDiscount() < 1.0) {
            return result + ", 优惠" + PriceFormatUtil.formatPrice(product.singleUnitPrice() * (1.0 - product.getDiscount())) + "(元)\n";
        }
        return result + "\n";
    }

    public Double getItemCost() {
        return getCount() * product.singleUnitPrice() * product.getDiscount();
    }

    public double getItemSaved() {
        return getCount() * product.singleUnitPrice() * (1 - product.getDiscount());
    }

}
