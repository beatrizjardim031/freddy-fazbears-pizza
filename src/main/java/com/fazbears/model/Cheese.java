package com.fazbears.model;

public class Cheese extends Topping {

    public Cheese(String name, boolean isExtra) {
        super(name, isExtra);
    }
    @Override
    public double calculatePrice(int pizzaSize) {
        double value;
        switch (pizzaSize) {
            case 8 -> {
                if (isExtra()){
                    value = .75 + .30;
                } else {
                    value = .75;
                }
            }
            case 12 -> {
                if (isExtra()) {
                    value = 1.50 + .60;
                } else {
                    value = 1.50;
                }
            }

            case 16 -> {
                if (isExtra()){
                    value = 2.25 + .90;
                } else {
                    value = 2.25;
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
