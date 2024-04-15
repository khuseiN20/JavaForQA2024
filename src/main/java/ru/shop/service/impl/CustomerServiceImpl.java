package ru.shop.service.impl;

import ru.shop.model.Customer;
import ru.shop.repository.CustomerRepository;
import ru.shop.repository.impl.CustomerRepositoryImpl;

import java.util.List;

public class CustomerServiceImpl implements CustomerRepository {
    private final CustomerRepositoryImpl ExceptCustomerRepository;

    public CustomerServiceImpl(CustomerRepositoryImpl ConstructorCustomerRepository) {
        this.ExceptCustomerRepository = ConstructorCustomerRepository;
    }

    public void save(Customer customer) {
        ExceptCustomerRepository.save(customer);
    }

    public List<Customer> findAll() {
        return ExceptCustomerRepository.findAll();
    }
}
