package com.thoughtworks;

import com.thoughtworks.Repository.ProductsRepo;
import com.thoughtworks.models.Order;
import com.thoughtworks.models.Product;

public class ReceiptPrinter {
    private ProductsRepo productsRepo = new ProductsRepo();

    public String processOrder(String barcodes) {
        String[] split = barcodes.split(",");
        Order order = new Order();
        for (String barcode : split) {
            Product product = productsRepo.GetProductByCode(barcode);
            order.add(product);
        }

        String cartItemsResult = order.getCartItemString();
        String orderTotalCostString = order.getTotalCostResult();
        return formatReceipt(cartItemsResult, orderTotalCostString);
    }

    private static String formatReceipt(String cartItemsString, String orderTotalCostString) {
        return "***<没钱赚商店>购物清单***\n" +
                cartItemsString +
                "----------------------\n" +
                orderTotalCostString +
                "**********************";
    }
}
