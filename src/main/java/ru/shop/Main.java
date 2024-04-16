package ru.shop;

import ru.shop.exception.BadOrderCountException;
import ru.shop.model.Customer;
import ru.shop.model.Order;
import ru.shop.model.Product;

import static ru.shop.model.ProductType.*;

import ru.shop.repository.CustomerRepository;
import ru.shop.repository.OrderRepository;
import ru.shop.repository.ProductRepository;
import ru.shop.repository.impl.CustomerRepositoryImpl;
import ru.shop.repository.impl.OrderRepositoryImpl;
import ru.shop.repository.impl.ProductRepositoryImpl;
import ru.shop.service.CustomerService;
import ru.shop.service.OrderService;
import ru.shop.service.ProductService;
import ru.shop.service.impl.CustomerServiceImpl;
import ru.shop.service.impl.OrderServiceImpl;
import ru.shop.service.impl.ProductServiceImpl;

import java.util.*;
import java.util.List;


public class Main {
    /*private static final CustomerRepository customerRepository = new CustomerRepository();
    private static final OrderRepository orderRepository = new OrderRepository();
    private static final ProductRepository productRepository = new ProductRepository();

    private static final CustomerService customerService = new CustomerService(customerRepository;
    private static final OrderService orderService = new OrderService(orderRepository);
    private static final ProductService productService = new ProductService(productRepository);*/

    private static final CustomerServiceImpl customerService = new CustomerServiceImpl(new CustomerRepositoryImpl());
    private static final OrderService orderService = new OrderServiceImpl(new OrderRepositoryImpl());
    private static final ProductService productService = new ProductServiceImpl(new ProductRepositoryImpl());

    public static void main(String[] args) {


        Customer customer1 = new Customer("1", "Dima", "88005553535", 19);
        customerService.save(customer1);

        Customer customer2 = new Customer("2", "Anna", "88005050", 25);
        customerService.save(customer2);

        Customer customer3 = new Customer("3", "Ded", "123123123", 44);
        customerService.save(customer3);

        Product product1 = new Product("1", "Услуга 1", 100, SERVICE);
        productService.save(product1);

        Product product2 = new Product("2", "Товар 1", 200, GOOD);
        productService.save(product2);

        Product product3 = new Product("2", "Услуга 2", 300, SERVICE);
        productService.save(product3);

        try {
            orderService.add(customer1, product1, 2);
            orderService.add(customer3, product3, 3);
            orderService.add(customer2, product2, -1);
        } catch (BadOrderCountException e) {
            System.out.println("Ошибка при добавлении заказа: " + e.getMessage());
        }

        System.out.println("Количество заказчиков: " + customerService.findAll().size());
        System.out.println("Количество заказов: " + orderService.findAll().size());

        System.out.println("Количество заказов типа GOOD: " + productService.findByProductType(GOOD).size());
        System.out.println("Количество заказов типа SERVICE: " + productService.findByProductType(SERVICE).size());

        List<Order> orders = orderService.findAll();
        Map<String, Integer> ordersByCustomers = new HashMap<>();

        for (Order order : orders) {
            Integer count = ordersByCustomers.get(order.customerId());
            if (count == null) {
                ordersByCustomers.put(order.customerId(), 1);
            } else {
                ordersByCustomers.put(order.customerId(), count + 1);
            }
        }
        for (Map.Entry<String, Integer> entry : ordersByCustomers.entrySet()) {
            System.out.println("ID покупателя: " + entry.getKey() + ", количество заказов: " + entry.getValue());
        }

        Map<String, Long> sumByCustomers = new HashMap<>();

        for (Order order : orders) {
            Long amount = sumByCustomers.get(order.customerId());
            if (amount == null) {
                sumByCustomers.put(order.customerId(), order.amount());
            } else {
                sumByCustomers.put(order.customerId(), amount + order.amount());
            }
        }
        for (Map.Entry<String, Long> entry : sumByCustomers.entrySet()) {
            System.out.println("ID покупателя: " + entry.getKey() + ", сумма для оплаты: " + entry.getValue());
        }
    }
}