package com.fazbears.ui;

import com.fazbears.model.Cheese;
import com.fazbears.model.Meat;
import com.fazbears.model.Order;
import com.fazbears.model.Pizza;

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

    //skeletons
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
                case 1 -> displayOrderScreen();
                case 0 -> isRunning = false;
                default -> System.out.println("Please select the right choice");
            }
        }
    }

    public void displayOrderScreen() {
        currentOrder = new Order();

        boolean isRunning = true;

        while (isRunning) {
            System.out.println("""
                    What would you like to order?
                    1) Add Pizza
                    2) Add drink
                    3) Add Garlic Knots
                    4) Checkout
                    0) Cancel
                    """);
            System.out.print("Choose your option: ");
            int userChoice = input.nextInt();
            input.nextLine();

            switch (userChoice) {
                case 1 -> displayAddPizzaScreen();
                case 2 -> System.out.println("addDrink()");
                case 3 -> System.out.println("AddGarlicKnots()");
                case 4 -> System.out.println("checkout()");
                case 0 -> {
                    System.out.println("Going back to main screen");
                    isRunning = false;
                    currentOrder = null;
                }
                default -> System.out.println("Please select the right choice");
            }
        }
    }

    public void displayAddPizzaScreen() {

        System.out.print("Select your crust type: ");
        String type = input.nextLine();

        System.out.print("\nPizza size: ");
        int size = input.nextInt();
        input.nextLine();

//        System.out.println("\nToppings (choose the amount of extra in each topping) : ");
//        System.out.print("\nMeat: ");
//
//        System.out.print("\nCheese: ");
//        System.out.print("\nOther toppings: ");

//        System.out.print("\nWhat sauce would you like? ");
        System.out.print("\nWould you like the pizza with stuffed crust? Y/N");
        String stuffedAnswer = input.nextLine();
        boolean isStuffed = stuffedAnswer.equalsIgnoreCase("Y");

        Pizza newPizza = new Pizza("custom Pizza", size, type, isStuffed);
        currentOrder.addProduct(newPizza);

    }

    private void addMeats(Pizza pizza) { //private method because only the class need to know about it
        boolean addingMeats = true;

        while(addingMeats) {
            System.out.println("""
                    Add a meat:
                    1) Pepperoni
                    2) Sausage
                    3) Ham
                    4) Bacon
                    5) Chicken
                    6) Meatball
                    0) Done
                    """);
            System.out.print("Choose: ");
            int userChoice = input.nextInt();
            input.nextLine();

            switch (userChoice) {

                case 1 -> addMeatToPizza("Pepperoni", pizza);
                case 2 -> addMeatToPizza("Sausage", pizza);
                case 3 -> addMeatToPizza("Ham", pizza);
                case 4 -> addMeatToPizza("Bacon", pizza);
                case 5 -> addMeatToPizza("Chicken", pizza);
                case 6 -> addMeatToPizza("Meatball", pizza);
                case 0 -> addingMeats = false;
                default -> System.out.println("Please select a valid option");
            }
        }
    }

    private void addMeatToPizza(String name, Pizza pizza) {
        System.out.print("Extra? Y/N: ");
        String extra = input.nextLine();
        boolean isExtra = extra.equalsIgnoreCase("Y");
        pizza.addTopping(new Meat(name, isExtra));
    }

    private void addCheese(Pizza pizza) { //private method because only the class need to know about it
        boolean addingCheese = true;

        while(addingCheese) {
            System.out.println("""
                    Add a cheese:
                    1) Mozzarella
                    2) Parmesan
                    3) Ricotta
                    4) Goat Cheese
                    5) Buffalo
                    0) Done
                    """);
            System.out.print("Choose: ");
            int userChoice = input.nextInt();
            input.nextLine();

            switch (userChoice) {

                case 1 -> addCheeseToPizza("Mozzarella", pizza);
                case 2 -> addCheeseToPizza("Parmesan", pizza);
                case 3 -> addCheeseToPizza("Ricotta", pizza);
                case 4 -> addCheeseToPizza("Goat Cheese", pizza);
                case 5 -> addCheeseToPizza("Buffalo", pizza);
                case 0 -> addingCheese = false;
                default -> System.out.println("Please select a valid option");
            }
        }
    }

    private void addCheeseToPizza(String name, Pizza pizza) {
        System.out.print("Extra? Y/N: ");
        String extra = input.nextLine();
        boolean isExtra = extra.equalsIgnoreCase("Y");
        pizza.addTopping(new Cheese(name, isExtra));
    }

//    private void addTopping(String name, Pizza pizza) {
//        System.out.print("Extra? Y/N: ");
//        String extra = input.nextLine();
//        boolean isExtra = extra.equalsIgnoreCase("Y");
//        pizza.addTopping(new Meat(name, isExtra));
//
//        System.out.print("Extra? Y/N: ");
//        String extraCheese = input.nextLine();
//        boolean isExtraCheese = extra.equalsIgnoreCase("Y");
//        pizza.addTopping(new Cheese(name, isExtra));
//
//
//    }
}
