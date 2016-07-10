package com.thoughtworks;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ReceiptPrinterTest {
    @Test
    public void should_get_receipt_message_when_given_1_coka_without_discount() throws Exception {
        String receiptString = new ReceiptPrinter().processOrder("ITEM000001");

        assertThat(receiptString, is("***<没钱赚商店>购物清单***\n" +
                "名称：可口可乐，数量：1瓶，单价：3.00(元)，小计：3.00(元)\n" +
                "----------------------\n" +
                "总计: 3.00(元)\n" +
                "节省：0.00(元)\n" +
                "**********************"));
    }

    @Test
    public void should_get_receipt_with_cost_6_message_when_given_1_apple_without_discount() throws Exception {
        String receiptString = new ReceiptPrinter().processOrder("ITEM000003");

        assertThat(receiptString, is("***<没钱赚商店>购物清单***\n" +
                "名称：苹果，数量：1斤，单价：5.50(元)，小计：5.50(元)\n" +
                "----------------------\n" +
                "总计: 5.50(元)\n" +
                "节省：0.00(元)\n" +
                "**********************"));
    }

    @Test
    public void should_get_receipt_with_two_products_message_when_given_1_apple_and_1_coka_without_discount() throws Exception {
        String receiptString = new ReceiptPrinter().processOrder("ITEM000001,ITEM000003");

        assertThat(receiptString, is("***<没钱赚商店>购物清单***\n" +
                "名称：可口可乐，数量：1瓶，单价：3.00(元)，小计：3.00(元)\n" +
                "名称：苹果，数量：1斤，单价：5.50(元)，小计：5.50(元)\n" +
                "----------------------\n" +
                "总计: 8.50(元)\n" +
                "节省：0.00(元)\n" +
                "**********************"));
    }
}