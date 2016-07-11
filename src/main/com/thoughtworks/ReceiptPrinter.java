package com.thoughtworks;

import com.thoughtworks.Repository.ProductsRepo;
import com.thoughtworks.models.Order;

import static java.util.Arrays.asList;

public class ReceiptPrinter {
    private ProductsRepo productsRepo = new ProductsRepo();

    public String processOrder(String barcodes) {
        Order order = new Order();

        addProductToOrder(barcodes, order);

        return formatReceipt(order.getCartItemString(), order.getTotalCostResult());
    }

    private void addProductToOrder(String barcodes, Order order) {
        asList(barcodes.split(",")).stream().forEach(barcode -> order.add(productsRepo.getProductByCode(barcode)));
    }

    private static String formatReceipt(String cartItemsString, String orderTotalCostString) {
        return "***<没钱赚商店>购物清单***\n" +
                cartItemsString +
                "----------------------\n" +
                orderTotalCostString +
                "**********************";
    }
}
