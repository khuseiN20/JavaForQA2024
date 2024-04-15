package ru.shop.repository;

import ru.shop.model.Order;

import java.util.ArrayList;
import java.util.List;

public interface OrderRepository {
    List<Order> orders = new ArrayList<>();

    void save(Order or);

    List<Order> findAll();
}
