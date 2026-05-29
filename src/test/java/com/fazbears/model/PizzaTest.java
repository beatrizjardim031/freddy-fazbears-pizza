package com.fazbears.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PizzaTest {

    @Test
    void calculatePriceShouldReturnBasePriceFor12InchPizza() {
        Pizza pizza = new Pizza("Test Pizza", 12, "Thin", false);

        double actual = pizza.calculatePrice();

        assertEquals(12.00, actual, 0.01);
    }

    @Test
    void CalculatePriceShouldIncludeStuffedCrust() {
        Pizza pizza = new Pizza("Test Pizza", 12, "Thin", true);

        double actual = pizza.calculatePrice();

        assertEquals(15.00, actual, 0.01);
    }

    @Test
    void addToppingShouldPreventDuplicateToppings() {
        Pizza pizza = new Pizza("Test Pizza", 12, "Thin", false);

        boolean first = pizza.addTopping(new Meat("Pepperoni"));
        boolean second = pizza.addTopping(new Meat("Pepperoni"));

        assertTrue(first);
        assertFalse(second);

        assertEquals(1, pizza.getToppings().size());
    }

    @Test
    void addToppingShouldPreventDuplicateToppingsIgnoringCase() {
        Pizza pizza = new Pizza("Test Pizza", 12, "Thin", false);

        pizza.addTopping(new Meat("Pepperoni"));
        boolean second = pizza.addTopping(new Meat("pepperoni"));

        assertFalse(second);
        assertEquals(1, pizza.getToppings().size());
    }


}