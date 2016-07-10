package com.thoughtworks.io;

import com.thoughtworks.models.Product;

import java.util.Properties;

public class ConfigReader {
    private static final String PREFIX = "Product.";

    public static boolean isProductNameLine(String key) {
        return key.startsWith(PREFIX) && key.endsWith(".name");
    }

    public static String toProductCode(String key) {
        return key.replaceAll(".name", "").replace(PREFIX, "");
    }

    public static Product toProduct(String productCode, Properties properties) {
        String name = properties.getProperty(PREFIX + productCode + ".name");
        double price = Double.parseDouble(properties.getProperty(PREFIX + productCode + ".price"));
        String unit = properties.getProperty(PREFIX + productCode + ".unit");
        String property = properties.getProperty(PREFIX + productCode + ".discountPercemtage");

        if (property != null) {
            return Product.buildDiscountProduct(productCode, name, price, unit, Double.parseDouble(property));
        }

        return Product.buildNormalProduct(productCode, name, price, unit);
    }

}
