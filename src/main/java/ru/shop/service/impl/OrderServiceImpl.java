package ru.shop.service.impl;

import ru.shop.exception.BadOrderCountException;
import ru.shop.model.Customer;
import ru.shop.model.Order;
import ru.shop.model.Product;
import ru.shop.repository.OrderRepository;
import ru.shop.repository.impl.OrderRepositoryImpl;
import ru.shop.service.OrderService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderServiceImpl implements OrderService {
    private final OrderRepositoryImpl ExceptOrderRepository;

    public OrderServiceImpl(OrderRepositoryImpl ConstructorOrderRepository) {
        this.ExceptOrderRepository = ConstructorOrderRepository;
    }

    public void add(Customer customer, Product product, int count) throws BadOrderCountException {
        if (count <= 0) {
            throw new BadOrderCountException("Количество товара меньше или рано 0!");
        }
        ExceptOrderRepository.save(new Order(UUID.randomUUID().toString(), customer.id(), product.id(), count, count * product.cost()));
    }

    public List<Order> findAll(){
        return ExceptOrderRepository.findAll();
    }

    public  List<Order> findByCustomer(Customer customer){
        List<Order> customerOrder = new ArrayList<>();
        for (Order order:findAll()){
            if(order.customerId().equals(customer.id())){
                customerOrder.add(order);
            }
        }
        return customerOrder;
    }

    public long getTotalCustomer(Customer customer){
        long totalAmount=0;
        for(Order order:findByCustomer(customer)){
            totalAmount += order.amount();
        }
        return totalAmount;
    }
}
