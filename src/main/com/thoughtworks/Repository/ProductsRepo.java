package com.thoughtworks.Repository;

import com.thoughtworks.io.ConfigReader;
import com.thoughtworks.models.Product;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class ProductsRepo {
    private List<Product> products;

    public static List<Product> loadProducts() {
        String path = ProductsRepo.class.getClassLoader().getResource("config.properties").getPath();;
        Properties properties = loadProperties(path);
        return properties.stringPropertyNames().stream()
                .filter(ConfigReader::isProductNameLine)
                .map(ConfigReader::toProductCode)
                .map(productCode -> ConfigReader.toProduct(productCode, properties))
                .collect(Collectors.toList());
    }

    private static Properties loadProperties(String configPath) {
        Properties properties = new Properties();
        try {
            properties.load(new InputStreamReader(new FileInputStream(configPath), "UTF-8"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }

    public ProductsRepo() {
        this.products = loadProducts();
    }

    public Product GetProductByCode(String barcode) {
        return products.stream().filter(item -> item.code().equals(barcode)).findFirst().get();
    }

}
