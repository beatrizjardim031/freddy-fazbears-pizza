package com.fazbears.ui;

import com.fazbears.model.*;

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

                case 1 -> addPremiumTopping(new Meat("Pepperoni"), pizza);
                case 2 -> addPremiumTopping(new Meat("Sausage"), pizza);
                case 3 -> addPremiumTopping(new Meat("Ham"), pizza);
                case 4 -> addPremiumTopping(new Meat("Bacon"), pizza);
                case 5 -> addPremiumTopping(new Meat("Chicken"), pizza);
                case 6 -> addPremiumTopping(new Meat("Meatball"), pizza);
                case 0 -> addingMeats = false;
                default -> System.out.println("Please select a valid option");
            }
        }
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

                case 1 -> addPremiumTopping(new Cheese("Mozzarella"), pizza);
                case 2 -> addPremiumTopping(new Cheese("Parmesan"), pizza);
                case 3 -> addPremiumTopping(new Cheese("Ricotta"), pizza);
                case 4 -> addPremiumTopping(new Cheese("Goat Cheese"), pizza);
                case 5 -> addPremiumTopping(new Cheese("Buffalo Cheese"), pizza);
                case 0 -> addingCheese = false;
                default -> System.out.println("Please select a valid option");
            }
        }
    }

    // refactored premium toppings into one single method
    private void addPremiumTopping (Topping topping, Pizza pizza) {
        String question = String.format("Would you like extra %s? Y/N: ", topping.getName());
        boolean isExtra = askYesNo(question);

        topping.setExtra(isExtra);

        pizza.addTopping(topping);
    }

    private void addCheeseToPizza(String name, Pizza pizza) {
        boolean isExtra = askYesNo("Would you like extra cheese? Y/N: ");
        pizza.addTopping(new Cheese(name, isExtra));
    }

// helper methods

    private String askForText (String prompt) {
        System.out.print(prompt);
        return input.nextLine();
    }

    private boolean askYesNo(String question) {
        System.out.printf(question);
        String userInput = input.nextLine();

        while (!userInput.equalsIgnoreCase("y") && !userInput.equalsIgnoreCase("n")) {
            System.out.printf(question);
            userInput = input.nextLine();
        }

        return userInput.equalsIgnoreCase("y");

    }

}
