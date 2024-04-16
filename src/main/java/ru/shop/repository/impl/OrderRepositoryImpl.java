package ru.shop.repository.impl;

import ru.shop.model.Order;
import ru.shop.repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;

public class OrderRepositoryImpl implements OrderRepository {
    private final List<Order> orders = new ArrayList<>();

    public void save(Order or) {
        orders.add(or);
    }

    public List<Order> findAll() {
        return orders;
    }
}
