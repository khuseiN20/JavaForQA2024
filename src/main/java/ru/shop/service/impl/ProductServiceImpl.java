package ru.shop.service.impl;

import ru.shop.model.Product;
import ru.shop.model.ProductType;
import ru.shop.repository.ProductRepository;
import ru.shop.repository.impl.ProductRepositoryImpl;
import ru.shop.service.ProductService;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private final ProductRepositoryImpl exceptProductRepository;

    public ProductServiceImpl(ProductRepositoryImpl constructorProductRepository) {
        this.exceptProductRepository = constructorProductRepository;
    }

    public void save(Product product) {
        exceptProductRepository.save(product);
    }

    public List<Product> findAll() {
        return exceptProductRepository.findAll();
    }

    public List<Product> findByProductType(ProductType type) {
        List<Product> arrayListByType = new ArrayList<>();
        for (Product product : findAll()) {
            if (product.productType() == type) {
                arrayListByType.add(product);
            }
        }
        return arrayListByType;

    }
}
