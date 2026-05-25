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

    private void addMeats(Pizza pizza) { // private method because only the class need to know about it
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

    private void addRegularToppings (Pizza pizza) {
        boolean addingTopping = true;

        while (addingTopping) {
            System.out.println("""
                    Other Toppings:
                    1) Onions
                    2) Mushrooms
                    3) Bell Peppers
                    4) Olives
                    5) Tomatoes
                    6) Spinach
                    7) Basil
                    8) Pineapple
                    9) Anchovies
                    0) Done
                    """);
            System.out.print("Choose: ");
            int userChoice = input.nextInt();
            input.nextLine();

            switch (userChoice) {
                case 1 -> pizza.addTopping(new RegularTopping("Onions"));
                case 2 -> pizza.addTopping(new RegularTopping("Mushrooms"));
                case 3 -> pizza.addTopping(new RegularTopping("Bell Peppers"));
                case 4 -> pizza.addTopping(new RegularTopping("Olives"));
                case 5 -> pizza.addTopping(new RegularTopping("Tomatoes"));
                case 6 -> pizza.addTopping(new RegularTopping("Spinach"));
                case 7 -> pizza.addTopping(new RegularTopping("Basil"));
                case 8 -> pizza.addTopping(new RegularTopping("Pineapple"));
                case 9 -> pizza.addTopping(new RegularTopping("Anchovies"));
                case 0 -> addingTopping = false;
                default -> System.out.println("Please select a valid option");
            }
        }
    }

    // refactored premium toppings into one single method
    private void addPremiumTopping(Topping topping, Pizza pizza) {
        String question = String.format("Would you like extra %s? Y/N: ", topping.getName());
        boolean isExtra = askYesNo(question);

        topping.setExtra(isExtra);

        pizza.addTopping(topping);
    }

    private void addSauce(Pizza pizza) {

        System.out.println("""
                    What sauce would you like on your pizza?
                    1) Marinara
                    2) Alfredo
                    3) Pesto
                    4) BBQ
                    5) Buffalo
                    6) Olive Oil
                    0) Done
                    """);
            System.out.print("Choose: ");
            int userChoice = input.nextInt();
            input.nextLine();

            switch (userChoice) {
                case 1 -> pizza.addSauce("Marinara");
                case 2 -> pizza.addSauce("Alfredo");
                case 3 -> pizza.addSauce("Pesto");
                case 4 -> pizza.addSauce("BBQ");
                case 5 -> pizza.addSauce("Buffalo");
                case 6 -> pizza.addSauce("Olive Oil");
                default -> System.out.println("Please select a valid option");
            }

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
