package com.fazbears.model;

public abstract class Product {
    //fields
    private String name;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double calculatePrice();

    @Override
    public String toString() {
        return String.format("%s - $%.2f", name, calculatePrice());
    }
}
