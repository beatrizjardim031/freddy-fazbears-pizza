package com.fazbears.model;

import java.util.ArrayList;
import java.util.List;

public class Pizza extends Product {
    //fields
    private int size;
    private String crustType;
    private List<Topping> toppings;
    private boolean isStuffedCrust;

    public Pizza(String name, int size, String crustType, boolean isStuffedCrust) {
        super(name);
        this.size = size;
        this.crustType = crustType;
        this.toppings = new ArrayList<>();
        this.isStuffedCrust = isStuffedCrust;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getCrustType() {
        return crustType;
    }

    public void setCrustType(String crustType) {
        this.crustType = crustType;
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

    public void setStuffedCrust(boolean stuffedCrust) {
        isStuffedCrust = stuffedCrust;
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    @Override
    public double calculatePrice() {
        double total = 0;
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
        return super.toString();
    }
}
