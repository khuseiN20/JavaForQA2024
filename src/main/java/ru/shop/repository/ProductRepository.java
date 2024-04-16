package ru.shop.repository;

import ru.shop.model.Product;
import java.util.ArrayList;
import java.util.List;

public interface ProductRepository {
    void save(Product pr);

    List<Product> findAll();
}
