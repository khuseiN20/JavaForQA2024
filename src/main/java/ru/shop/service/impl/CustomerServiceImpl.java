package ru.shop.service.impl;

import ru.shop.model.Customer;
import ru.shop.repository.CustomerRepository;
import ru.shop.repository.impl.CustomerRepositoryImpl;

import java.util.List;

public class CustomerServiceImpl implements CustomerRepository {
    private final CustomerRepositoryImpl exceptCustomerRepository;

    public CustomerServiceImpl(CustomerRepositoryImpl constructorCustomerRepository) {
        this.exceptCustomerRepository = constructorCustomerRepository;
    }

    public void save(Customer customer) {
        exceptCustomerRepository.save(customer);
    }

    public List<Customer> findAll() {
        return exceptCustomerRepository.findAll();
    }
}