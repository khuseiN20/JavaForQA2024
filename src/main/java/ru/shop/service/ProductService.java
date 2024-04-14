package ru.shop.service;

import ru.shop.model.Product;
import ru.shop.model.ProductType;
import ru.shop.repository.ProductRepository;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private final ProductRepository ExceptProductRepository;

    public ProductService(ProductRepository ConstructorProductRepository) {
        this.ExceptProductRepository = ConstructorProductRepository;
    }

    public void save(Product product) {
        ExceptProductRepository.save(product);
    }

    public List<Product> findAll() {
        return ExceptProductRepository.findAll();
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
