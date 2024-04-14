package ru.shop.model;

import java.util.Objects;

public record Product(String id, String name, long cost, ProductType productType) {
}