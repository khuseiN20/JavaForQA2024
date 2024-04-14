package ru.shop.model;

import java.util.Objects;

public record Order(String id, String customerId, String productID, long count, long amount) {
}
