package com.fazbears.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<Product> products;
    private final LocalDateTime orderDate;

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

    public boolean isEmpty() {
        return products.isEmpty();
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
        StringBuilder builder = new StringBuilder();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a");
        String formattedOrderDate = orderDate.format(formatter);
        builder.append("Order Date: ").append(formattedOrderDate).append("\n");
        builder.append(" ------------------------------------------------------------- \n");

        if (products.isEmpty()) {
            builder.append(" No items in order.\n");
        } else {
            for (int i = 0; i < products.size(); i++) {
                builder.append("\n Item ").append(i + 1).append(":\n");
                builder.append(" ------------------------------------------------------------- \n");
                builder.append(products.get(i)).append("\n");
            }
        }

        builder.append(" ------------------------------------------------------------- \n");
        builder.append(String.format(" Total: $%.2f%n", calculateTotal()));

        return builder.toString();
    }
}

