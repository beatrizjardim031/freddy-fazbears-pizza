package com.fazbears.data;

import com.fazbears.model.Drink;
import com.fazbears.model.Order;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class ReceiptManagerTest {

    @Test
    void saveReceiptShouldCreateReceiptFolder() {
        Order order = new Order();
        order.addProduct(new Drink("Large Faz-Fizz Cola", "Large", "Faz-Fizz Cola"));

        ReceiptManager.saveReceipt(order);

        File receiptsFolder = new File("receipts");

        assertTrue(receiptsFolder.exists());
        assertTrue(receiptsFolder.isDirectory());
    }
}