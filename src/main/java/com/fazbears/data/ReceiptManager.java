package com.fazbears.data;

import com.fazbears.model.Order;
import com.fazbears.model.Product;

import java.io.*;
import java.time.format.DateTimeFormatter;

public class ReceiptManager {

    public static void saveReceipt (Order order) {
        File receiptsFolder = new File("receipts");
        boolean folderCreated = receiptsFolder.mkdirs(); //this method creates the folder if it doesn't exist, like the Git Bash method

        // defines the date/time pattern for the filename
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        String fileName = order.getOrderDate().format(formatter) + ".txt"; // formats the order date into a string and adds .txt extension

        try {
            // creates a new file in the receipts folder
            FileWriter fileWriter = new FileWriter("receipts/" + fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // loops through each product and writes it to the file
            for (Product product : order.getProducts()){
                bufferedWriter.write(product.toString()); // writes the product name and price

                bufferedWriter.newLine(); // moves to the next line
            }
            bufferedWriter.write(String.format("Total: $%.2f%n", order.calculateTotal())); // writes the total price at the bottom


            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Error. Could not load this file.");
        }

    }
}
