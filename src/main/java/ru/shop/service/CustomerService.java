package ru.shop.service;

import ru.shop.model.Customer;
import ru.shop.repository.CustomerRepository;

import java.util.List;

public class CustomerService {
    private final CustomerRepository ExceptCustomerRepository;

    public CustomerService(CustomerRepository ConstructorCustomerRepository) {
        this.ExceptCustomerRepository = ConstructorCustomerRepository;
    }

    public void save(Customer customer) {
        ExceptCustomerRepository.save(customer);
    }

    public List<Customer> findAll() {
        return ExceptCustomerRepository.findAll();
    }
}
