package ru.shop.repository;

import ru.shop.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    List<Product> products = new ArrayList<>();

    public void save(Product pr) {
        products.add(pr);
    }

    public List<Product> findAll() {
        return products;
    }
}
