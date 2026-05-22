package com.fazbears.model;

public class RegularTopping extends Topping {

    public RegularTopping(String name, boolean isExtra) {
        super(name, isExtra);
    }

    @Override
    public double calculatePrice(int pizzaSize) {
        return 0;
    }
}
