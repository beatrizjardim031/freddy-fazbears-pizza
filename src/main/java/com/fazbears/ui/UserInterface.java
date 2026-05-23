package com.fazbears.ui;

import com.fazbears.model.Order;

import java.util.Scanner;

public class UserInterface {

    private Scanner input;
    private Order currentOrder;

    public UserInterface() {
        this.input = new Scanner(System.in);
    }

    public Scanner getInput() {
        return input;
    }

    public Order getCurrentOrder() {
        return currentOrder;
    }

    public void start() {
        System.out.println("Welcome banner");

        boolean isRunning = true;


        while(isRunning) {
            System.out.println("""
                What would you like to do? (1st menu)
                1) New Order
                0) Exit
                """);
            System.out.print("Choose your option: ");
            int userChoice = input.nextInt();
            input.nextLine();

            switch (userChoice) {
                case 1 -> System.out.println("placeHolderForNewOrder");
                case 0 -> isRunning = false;
                default -> System.out.println("Please select the right choice");
            }
        }

    }
}
