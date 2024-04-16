package ru.shop.service;

import ru.shop.model.Product;
import ru.shop.model.ProductType;
import ru.shop.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public interface ProductService {
    void save(Product product);

    List<Product> findAll();

    List<Product> findByProductType(ProductType type);
}