package ru.shop.model;

public record Product(String id, String name, long cost, ProductType productType) {
}
