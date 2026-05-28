package com.fazbears.model;

public class Meat extends Topping {

    public Meat (String name, boolean isExtra) {
        super(name, isExtra);
    }

    // defined another constructor with extra set to false so I can use a constructor that takes only 1 parameter
    public Meat(String name) {
        super(name, false);
    }

    @Override
    public double calculatePrice(int pizzaSize) {
        double value;
        switch (pizzaSize) {
            case 8 -> {
                if (isExtra()){
                    value = 1.00 + .50;
                } else {
                    value = 1.00;
                }
            }
            case 12 -> {
                if (isExtra()){
                    value = 2.00 + 1.00;
                } else {
                    value = 2.00;
                }
            }

            case 16 -> {
                if (isExtra()){
                    value = 3.00 + 1.50;
                } else {
                    value = 3.00;
                }
            }

            default -> {
                    value = 0;
                    System.out.println("We don't reconize this value, please try again.");
            }
        }
        return value;
    }

}
