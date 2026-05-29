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




}