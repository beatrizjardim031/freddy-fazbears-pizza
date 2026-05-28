package com.fazbears.model;

public class ChicasKitchenFeast extends Pizza {

    public ChicasKitchenFeast() {
        super("Chica's Kitchen Feast", 16, "Thick", true);

        addTopping(new Meat("Chicken"));
        addTopping(new Meat("Bacon"));
        addTopping(new Cheese("Mozzarella"));
        addTopping(new Cheese("Ricotta"));

        addTopping(new RegularTopping("Mushrooms"));
        addTopping(new RegularTopping("Bell Peppers"));
        addTopping(new RegularTopping("Spinach"));
        addTopping(new RegularTopping("Onions"));

        addSauce("Alfredo");
    }
}
