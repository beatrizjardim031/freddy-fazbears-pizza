package com.fazbears.model;

public class GarlicKnots extends Product{
    private int quantity;

    public GarlicKnots(String name, int quantity) {
        super(name);
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public double calculatePrice() {
        double total;
        total = quantity * 1.50;

        return total;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
