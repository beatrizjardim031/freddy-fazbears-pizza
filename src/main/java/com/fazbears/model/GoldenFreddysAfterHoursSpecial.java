package com.fazbears.model;

public class GoldenFreddysAfterHoursSpecial extends Pizza {

    public GoldenFreddysAfterHoursSpecial() {
        super("Golden Freddy's After-Hours Special", 12, "Thin", false);

        addTopping(new Meat("Meatball"));
        addTopping(new Meat("Sausage"));
        addTopping(new Cheese("Mozzarella"));
        addTopping(new Cheese("Goat Cheese"));
        addTopping(new RegularTopping("Olives"));
        addTopping(new RegularTopping("Mushrooms"));
        addTopping(new RegularTopping("Basil"));

        addSauce("Pesto");
        addSauce("Special Sauce... You will taste it.");

    }
}
