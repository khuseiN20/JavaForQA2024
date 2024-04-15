package ru.shop.repository;

import ru.shop.model.Customer;


import java.util.ArrayList;
import java.util.List;

public interface CustomerRepository {
    List<Customer> customers = new ArrayList<>();

    void save(Customer cu);

    List<Customer> findAll();
}