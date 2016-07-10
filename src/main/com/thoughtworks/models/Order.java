package com.thoughtworks.models;

import com.thoughtworks.utils.PriceFormatUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Order {

    private List<OrderItem> orderItems;

    public Order() {
        orderItems = new ArrayList<>();
    }

    public String getCartItemString() {
        StringBuilder stringBuilder = new StringBuilder();
        orderItems.stream().map(orderItem -> stringBuilder.append(orderItem.getOrderItemString())).collect(Collectors.toList());
        return stringBuilder.toString();
    }
    
    public void add(Product product) {
        OrderItem orderItem = new OrderItem(product);
        orderItems.add(orderItem);
    }

    public String getTotalCostResult() {
        return "总计: " + getAllCost() + "(元)\n" +
                "节省："+getSavedMoney()+"(元)\n";
    }

    public String getAllCost() {
        Double allCost = 0.0;
        for (OrderItem orderItem : orderItems) {
            allCost += orderItem.getItemCost();
        }

        return PriceFormatUtil.formatPrice(allCost);
    }

    public String getSavedMoney() {
        double allSaved = 0.0;
        for (OrderItem orderItem : orderItems) {
            allSaved += orderItem.getItemSaved();
        }

        return PriceFormatUtil.formatPrice(allSaved);
    }
}
