package ru.shop.model;

public record Order(String id, String customerId, String productID, long count, long amount) {
}
