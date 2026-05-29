package com.fazbears.model;

import java.util.ArrayList;
import java.util.List;

public class Pizza extends Product {
    //fields
    private int size;
    private String crustType;
    private List<Topping> toppings;
    private boolean isStuffedCrust;
    private final List<String> sauces;
    private final List<String> extras;

    public Pizza(String name, int size, String crustType, boolean isStuffedCrust) {
        super(name);
        this.size = size;
        this.crustType = crustType;
        this.toppings = new ArrayList<>();
        this.isStuffedCrust = isStuffedCrust;
        this.sauces = new ArrayList<>();
        this.extras = new ArrayList<>();
    }

    public int getSize() {
        return size;
    }

    public String getCrustType() {
        return crustType;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }

    public boolean isStuffedCrust() {
        return isStuffedCrust;
    }

    public List<String> getSauces() {
        return sauces;
    }

    public boolean addTopping(Topping topping) {
        if (hasToppings(topping.getName())) {
            return false;
        }
        toppings.add(topping);
        return true;
    }

    public boolean hasToppings(String toppingName) {
        return toppings.stream()
                .anyMatch(topping -> topping.getName().equalsIgnoreCase(toppingName));
    }

    public void removeTopping(Topping topping) {
        toppings.remove(topping);
    }

    public void addSauce(String sauce) {
        sauces.add(sauce);
    }

    @Override
    public double calculatePrice() {
        double total;
        switch (size) {
            case 8 -> total = 8.50;
            case 12 -> total = 12.00;
            case 16 -> total = 16.50;
            default -> total = 0;

        }
        for (Topping topping : toppings) {
            total +=  topping.calculatePrice(size);
        }
        if (isStuffedCrust) {
            total += 3.00;
        }

        return total;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("%d\" %s", getSize(), getName()));
        stringBuilder.append(String.format("%nCrust: %s", getCrustType()));
        stringBuilder.append(String.format("%nStuffed Crust: %s", isStuffedCrust() ? "Yes" : "No"));

            stringBuilder.append("\nToppings: ");
            for (int i = 0; i < toppings.size(); i++) {
                if (i > 0) {
                    stringBuilder.append(", ");
                }
                stringBuilder.append(toppings.get(i));
                if (toppings.get(i).isExtra()) {
                    stringBuilder.append(" (extra)");
                }
            }

        if (sauces.isEmpty()) {
            stringBuilder.append("\nSauce: None");
        } else {
            stringBuilder.append("\nSauce: ").append(getSauces().get(0));
        }
        stringBuilder.append(String.format("%nPizza Total: $%.2f", calculatePrice()));
        return stringBuilder.toString();
    }
}
