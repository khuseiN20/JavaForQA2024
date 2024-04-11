package ru.shop;

import ru.shop.exception.BadOrderCountException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

}

enum ProductType {
    GOOD,
    SERVICE;
}

record Product(String id, String name, long cost, ProductType productType) {
}

record Customer(String id, String name, String phone, long age) {
}

record Order(String id, String customerId, String productID, long count, long amount) {
}

class ProductRepository {
    List<Product> products = new ArrayList<>();

    public void save(Product pr) {
        products.add(pr);
    }

    public List<Product> findAll() {
        return products;
    }
}

class OrderRepository {
    List<Order> orders = new ArrayList<>();

    public void save(Order or) {
        orders.add(or);
    }

    public List<Order> findAll() {
        return orders;
    }
}

class CustomerRepository {
    List<Customer> customers = new ArrayList<>();

    public void save(Customer cu) {
        customers.add(cu);
    }

    public List<Customer> findAll() {
        return customers;
    }
}

class ProductService {
    private final ProductRepository ExceptProductRepository;

    public ProductService(ProductRepository ConstructorProductRepository) {
        this.ExceptProductRepository = ConstructorProductRepository;
    }

    public void save(Product product) {
        ExceptProductRepository.save(product);
    }

    public List<Product> findAll() {
        return ExceptProductRepository.findAll();
    }

    public List<Product> findByProductType(ProductType type) {
        List<Product> arrayListByType = new ArrayList<>();
        for (Product product : findAll()) {
            if (product.productType() == type) {
                arrayListByType.add(product);
            }
        }
        return arrayListByType;
    }
}

class CustomerService {
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

class OrderService {
    private final OrderRepository ExceptOrderRepository;

    public OrderService(OrderRepository ConstructorOrderRepository) {
        this.ExceptOrderRepository = ConstructorOrderRepository;
    }

    public void add(Customer customer, Product product, int count) throws BadOrderCountException {
        if (count <= 0) {
            throw new BadOrderCountException("Количество товара меньше или рано 0!");
        }
        Order order = new Order(UUID.randomUUID().toString(), customer.id(), product.id(), count, count * product.cost());
    }

    public List<Order>  findAll(){
        return ExceptOrderRepository.findAll();
    }

    public  List<Order> findByCustomer(Customer customer){
            List<Order> customerOrder = new ArrayList<>();
            for (Order order:findAll()){
                if(order.customerId()== customer.id()){
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

