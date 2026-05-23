package com.fazbears.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Product> products;
    private LocalDateTime orderDate;

    public Order() {
        this.products = new ArrayList<>();
        this.orderDate = LocalDateTime.now();
    }

    public List<Product> getProducts() {
        return products;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public double calculateTotal() {
        double totalPrice = 0;

        for(Product product : products) {
            totalPrice += product.calculatePrice();
        }
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "products=" + products +
                ", orderDate=" + orderDate +
                '}';
    }
}
