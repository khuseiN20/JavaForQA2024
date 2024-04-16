package ru.shop.repository;

import ru.shop.model.Order;

import java.util.ArrayList;
import java.util.List;

public interface OrderRepository {
    void save(Order or);

    List<Order> findAll();
}
