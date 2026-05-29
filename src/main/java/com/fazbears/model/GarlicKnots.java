package com.fazbears.model;

public class GarlicKnots extends Product{
    private final int quantity;

    public GarlicKnots(String name, int quantity) {
        super(name);
        this.quantity = quantity;
    }

    @Override
    public double calculatePrice() {
        double total;
        total = quantity * 1.50;

        return total;
    }

    @Override
    public String toString() {
        return String.format("%s x%d - $%.2f", getName(), quantity, calculatePrice());
    }
}
