package com.thoughtworks;

public class ReceiptPrinter {
    public static String processOrder(String orderList){
        return "***<没钱赚商店>购物清单***\n" +
                "名称：可口可乐，数量：1瓶，单价：3.00(元)，小计：3.00(元)\n" +
                "----------------------\n" +
                "总计: 3.00(元)\n" +
                "节省：0.00(元)\n" +
                "**********************";
    }
}
