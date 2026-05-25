package com.fazbears.model;

public class RegularTopping extends Topping {


    public RegularTopping(String name) {
        super(name, false);
    }


    @Override
    public double calculatePrice(int pizzaSize) {
        return 0;
    }
}
