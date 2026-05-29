package com.fazbears.data;

import com.fazbears.model.Order;

import java.io.*;
import java.time.format.DateTimeFormatter;

public class ReceiptManager {

    public static void saveReceipt (Order order) {
        File receiptsFolder = new File("receipts");
        receiptsFolder.mkdirs(); //this method creates the folder if it doesn't exist, like the Git Bash method

        // defines the date/time pattern for the filename
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        String fileName = order.getOrderDate().format(formatter) + ".txt"; // formats the order date into a string and adds .txt extension

        try {
            // creates a new file in the receipts folder
            FileWriter fileWriter = new FileWriter("receipts/" + fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Order.toString() already formats the receipt with date, item numbers, dividers, and total.
            bufferedWriter.write(order.toString());

            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Error. Could not save this receipt file.");
        }

    }
}
