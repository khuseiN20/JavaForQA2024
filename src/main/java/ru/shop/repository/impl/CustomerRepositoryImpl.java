package ru.shop.repository.impl;

import ru.shop.model.Customer;
import ru.shop.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {
    List<Customer> customers = new ArrayList<>();

    public void save(Customer cu) {
        customers.add(cu);
    }

    public List<Customer> findAll() {
        return customers;
    }
}
