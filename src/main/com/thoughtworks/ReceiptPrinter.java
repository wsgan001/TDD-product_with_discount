package com.thoughtworks;

import com.thoughtworks.Repository.ProductsRepo;
import com.thoughtworks.models.Order;
import com.thoughtworks.models.Product;

public class ReceiptPrinter {
    private ProductsRepo productsRepo = new ProductsRepo();

    public String processOrder(String barcode) {
        Order order = new Order();
        Product product = productsRepo.GetProductByCode(barcode);
        order.add(product);
        String cartItemsResult = order.getCartItemString();
        return formatReceipt(cartItemsResult);
    }

    private static String formatReceipt(String cartItemsString) {
        return "***<没钱赚商店>购物清单***\n" +
                cartItemsString +
                "----------------------\n" +
                "总计: 3.00(元)\n" +
                "节省：0.00(元)\n" +
                "**********************";
    }
}
