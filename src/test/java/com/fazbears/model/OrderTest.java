package com.fazbears.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void newOrderShouldStartEmpty() {
        Order order = new Order();

        assertTrue(order.isEmpty());
        assertEquals(0, order.getProducts().size());
    }

    @Test
    void addProductShouldAddItemToOrder() {
        Order order = new Order();
        Drink drink = new Drink("Large Faz-Fizz Cola", "Large", "Faz-Fizz Cola");

        order.addProduct(drink);

        assertFalse(order.isEmpty());
        assertEquals(1, order.getProducts().size());
    }

    @Test
    void removeProductShouldRemoveItemFromOrder() {
        Order order = new Order();
        Drink drink = new Drink("Large Faz-Fizz Cola", "Large", "Faz-Fizz Cola");

        order.addProduct(drink);
        order.removeProduct(drink);

        assertTrue(order.isEmpty());
        assertEquals(0, order.getProducts().size());
    }

    @Test
    void calculateTotalShouldAddAllProductPrices() {
        Order order = new Order();
        Drink drink = new Drink("Large Faz-Fizz Cola", "Large", "Faz-Fizz Cola");
        Pizza pizza = new Pizza("Test Pizza", 12, "Thin", false);

        order.addProduct(drink);
        order.addProduct(pizza);

        assertEquals(15.00, order.calculateTotal(), 0.01);
    }

}