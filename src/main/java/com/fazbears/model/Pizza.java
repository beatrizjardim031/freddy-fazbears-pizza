package com.fazbears.model;

import java.util.ArrayList;
import java.util.List;

public class Pizza extends Product {
    //fields
    private final int size;
    private final String crustType;
    private List<Topping> toppings;
    private final boolean isStuffedCrust;
    private final List<String> sauces;

    public Pizza(String name, int size, String crustType, boolean isStuffedCrust) {
        super(name);
        this.size = size;
        this.crustType = crustType;
        this.toppings = new ArrayList<>();
        this.isStuffedCrust = isStuffedCrust;
        this.sauces = new ArrayList<>();
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

    // Adds a topping only if the pizza does not already have it.
    // This prevents duplicate toppings, especially when customizing signature pizzas.
    // Returns true if the topping was added, false if it was already on the pizza.
    public boolean addTopping(Topping topping) {
        if (hasToppings(topping.getName())) {
            return false;
        }
        toppings.add(topping);
        return true;
    }

   // Checks if a topping already exists on the pizza.
    // I used a stream here because it reads like:
   // "Does any topping match this topping name?"
    public boolean hasToppings(String toppingName) {
        return toppings.stream()
                .anyMatch(topping -> topping.getName().equalsIgnoreCase(toppingName));
    }

    // This is used when customizing signature pizzas.
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

        // StringBuilder helps build a longer String step by step.
       // I use it here because the pizza receipt has multiple lines:
        // size/name, crust, stuffed crust, toppings, sauce, and total.
       // This is cleaner than combining everything with many +
        StringBuilder stringBuilder = new StringBuilder();

        // Add the pizza size and name first.
        stringBuilder.append(String.format("%d\" %s", getSize(), getName()));

        // Each append adds another line to the final String.
        // %n creates a new line in a platform-safe way.
        stringBuilder.append(String.format("%nCrust: %s", getCrustType()));

        // Adds whether the pizza has stuffed crust.
        // the ternary operator prints "yes" if isStuffedCrust is true,
        // otherwise it prints "no".
        stringBuilder.append(String.format("%nStuffed Crust: %s", isStuffedCrust() ? "Yes" : "No"));


        // Start the toppings line.
        // The loop below will add each topping to this same line.
            stringBuilder.append("\nToppings: ");
            for (int i = 0; i < toppings.size(); i++) {
                // Add a comma before every topping except the first one.
                // This keeps the toppings readable
                if (i > 0) {
                    stringBuilder.append(", ");
                }

                // Add the topping name.
                stringBuilder.append(toppings.get(i));
                if (toppings.get(i).isExtra()) {
                    stringBuilder.append(" (extra)");
                }
            }

        // Add sauce information.
        // If the list is empty, print None. Otherwise, print the sauce name
        if (sauces.isEmpty()) {
            stringBuilder.append("\nSauce: None");
        } else {
            stringBuilder.append("\nSauce: ").append(getSauces().get(0));
        }
        stringBuilder.append(String.format("%nPizza Total: $%.2f", calculatePrice()));
        return stringBuilder.toString();
    }
}
