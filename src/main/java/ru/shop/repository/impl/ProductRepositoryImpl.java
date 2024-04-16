package ru.shop.repository.impl;

import ru.shop.model.Product;
import ru.shop.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {
    private final List<Product> products = new ArrayList<>();

    public void save(Product pr) {
        products.add(pr);
    }

    public List<Product> findAll() {
        return products;
    }
}
