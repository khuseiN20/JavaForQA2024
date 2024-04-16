package ru.shop.repository;

import ru.shop.model.Customer;


import java.util.ArrayList;
import java.util.List;

public interface CustomerRepository {

    void save(Customer cu);

    List<Customer> findAll();
}