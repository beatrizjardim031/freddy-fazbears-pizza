package com.fazbears.model;

public abstract class Topping {
    private String name;
    private boolean isExtra;

    public Topping(String name, boolean isExtra) {
        this.name = name;
        this.isExtra = isExtra;
    }

    public String getName() {
        return name;
    }

    public boolean isExtra() {
        return isExtra;
    }

    public void setExtra(boolean extra) {
        isExtra = extra;
    }

    public abstract double calculatePrice (int pizzaSize);

    @Override
    public String toString() {
        return "Topping{" +
                "name='" + name + '\'' +
                ", isExtra=" + isExtra +
                '}';
    }
}
