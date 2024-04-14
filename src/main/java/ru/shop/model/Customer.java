package ru.shop.model;

import java.util.Objects;

public record Customer(String id, String name, String phone, long age) {
}