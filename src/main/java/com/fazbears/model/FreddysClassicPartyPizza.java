package com.fazbears.model;

public class FreddysClassicPartyPizza extends Pizza {

    public FreddysClassicPartyPizza() {
        super("Freddy's Classic Party Pizza", 12, "Regular", false);

        addTopping(new Meat("Pepperoni"));
        addTopping(new Cheese("Mozzarella"));
        addTopping(new Cheese("Parmesan"));
        addTopping(new RegularTopping("Tomato"));
        addTopping(new RegularTopping("Basil"));

        addSauce("Marinara");

    }


}
