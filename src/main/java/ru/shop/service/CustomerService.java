package ru.shop.service;

import ru.shop.model.Customer;
import ru.shop.repository.CustomerRepository;
import ru.shop.repository.impl.CustomerRepositoryImpl;

import java.util.List;

public interface CustomerService {
    void save(Customer customer);
    List<Customer> findAll();
}
