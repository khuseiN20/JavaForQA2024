package ru.shop.service;

import ru.shop.exception.BadOrderCountException;
import ru.shop.model.Customer;
import ru.shop.model.Product;
import ru.shop.model.Order;
import ru.shop.repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface OrderService {
    void add(Customer customer, Product product, int count) throws BadOrderCountException;

    List<Order> findAll();

    List<Order> findByCustomer(Customer customer);

    public long getTotalCustomer(Customer customer);
}
