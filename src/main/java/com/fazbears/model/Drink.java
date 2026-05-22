package com.fazbears.model;

public class Drink extends Product {
    private String size;
    private String flavor;

    public Drink(String name, String size, String flavor) {
        super(name);
        this.size = size;
        this.flavor = flavor;
    }

    public String getSize() {
        return size;
    }

    public String getFlavor() {
        return flavor;
    }

    @Override
    public double calculatePrice() {
        double total;
        switch (size.toLowerCase()) {
            case "small" -> total = 2.00;
            case "medium" -> total = 2.50;
            case "large" -> total = 3.00;
            default -> total = 0;

        }
        return total;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
