package com.fazbears.ui;

import com.fazbears.data.ReceiptManager;
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
        System.out.println("""
        ==========================================================
                       FREDDY FAZBEAR'S PIZZERIA
        ==========================================================
                             ⣎⠉⠉⠉⠉⠉⠉⠉⠉⣱⠀⠀⠀⠀⠀⠀⠀⠀⠀          ⠀
                              ⢻⠀⠀⠀⠀⠀⠀⠀⠀⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                            ⢰⠚⠒⠒⠒⠒⠒⠒⠒⠒⠓⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀
                   ⢀⣀⣀⣀⠀⢠⡤⢄⣸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣇⡠⢤⡄⠀⣀⣀⣀⡀
                  ⡰⠕⠀⠐⠂⠍⡆⠙⣭⣛⡀⠤⠤⠤⠤⠤⠤⠤⠄⢐⣛⣭⠋⢰⡩⠐⠐⠫⢆
                 ⢣⢄⠀⠀⢀⢠⢛⠞⠁⠀⠉⠉⠁⠒⠒⠒⠒⠈⠉⠉⠀⠈⠳⡛⡄⡀⠀⠀⡠⡜
                  ⠳⣕⠀⣰⣻⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀   ⠀⠙⣝⣆⠀⣪⠞⠀
                     ⠉⢠⠇⠀⠀⠀⣀⣀⣀⠀⠀⠀⠀⠀⠀⣀⣀⣀⠀⠀⠀⠸⡄⠉⠀⠀⠀
                      ⢸⠀⠀⢠⡾⠿⠿⠿⣿⣄⠀⠀⣠⣿⠿⠿⠿⢷⡀⠀⠀⡇⠀⠀⠀⠀
                      ⢸⠀⠀⠈⢀⣶⠛⠛⢦⠙⠀⠐⠋⡶⠛⠛⣷⡀⠀⠀⠀⡇⠀⠀⠀⠀
                      ⡸⠃⠀⠀⠸⣷⡈⡃⣸⠇⠀⠀⠸⣇⢹⠁⣾⠇⠀⠀⠘⢇⠀⠀⠀⠀
                    ⢸⠁⠀⠀⠀⢀⣩⠿⢿⡭⠤⢶⣶⣤⣭⡿⠿⣉⣀⠀⠀⠀  ⠈⡆⠀⠀⠀
                     ⠘⢆⡀⢀⡞⠁⠀⠀⠀⠙⠛⠿⠿⠛⠋⠀⠀⠀⠈⢳⡀⠀⡰⠃⠀⠀⠀
                       ⢹⢾⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀  ⢠⡗  ⡏⠀⠀⠀⠀⠀
                       ⠸⡄⢷⣀⠀⠀⠀⠀⠀⣠⣄⠀⠀⠀⠀⠀  ⢀⡾ ⢠⠃⠀⠀⠀⠀⠀
                        ⢣⠈⠫⣹⡒⠚⢉⠉⢉⡉⠉⣉⠓⢒⣏⠝⠁⡞⠀⠀⠀⠀⠀⠀
                         ⠳⡀⠈⠙⠒⠛⠤⠼⠧⠤⠛⠒⠋⠁⣀⠞⠁⠀⠀⠀⠀⠀⠀
                          ⠈⠓⠦⠤⣤⣀⣠⣄⣀⣠⠤⠴⠚⠁⠀⠀⠀⠀⠀⠀⠀⠀
                 Family Fun, Fresh Pizza, Forever Memories
        ---------------------------------------------------------------
        | House Notice:                                               |   
        | If you hear music from the vents, please notify staff.      |
        """);

        boolean isRunning = true;

        while (isRunning) {
            System.out.println("""
                    |                                                             |
                    |-------------------------------------------------------------|
                    |Ready to order?                                              |
                    |1) New Order                                                 |
                    |0) Exit                                                      |
                    ===============================================================
                    """);
            System.out.print("Choose your option: ");
            String userChoice = input.nextLine();

            switch (userChoice) {
                case "1" -> displayOrderScreen();
                case "0" -> isRunning = false;
                default -> System.out.println("Please select the right choice");
            }
        }
    }

    public void displayOrderScreen() {
        currentOrder = new Order();

        boolean isRunning = true;
        System.out.println("""
                |=============================================================|
                |                FREDDY FAZBEAR'S PIZZERIA                    |  
                |                  Family Fun. Fresh Pizza.                   |
                |=============================================================|
                |                          NEW ORDER                          | 
                |-------------------------------------------------------------|
                | House Notice:                                               |
                | Please remain with your party until your order is complete. | 
                ---------------------------------------------------------------
                """);

        while (isRunning) {
            System.out.println("""
                    |                                                             |
                    | 1) Add Pizza                                                |
                    | 2) Add drink                                                | 
                    | 3) Add Garlic Knots                                         |
                    | 4) Checkout                                                 |  
                    | 0) Cancel                                                   |
                    ---------------------------------------------------------------
                    """);
            String userChoice = askForText("Choose your option: ");

            switch (userChoice) {
                case "1" -> displayAddPizzaScreen();
                case "2" -> addDrink();
                case "3" -> addGarlicKnots();
                case "4" -> {
                    boolean completed = checkout();
                    if (completed) {
                        isRunning = false;
                    }
                }
                case "0" -> {
                    System.out.println("Going back to main screen");
                    isRunning = false;
                    currentOrder = null;
                }
                default -> System.out.println("Please select the right choice");
            }
        }
    }

    private void displayAddPizzaScreen() {

        System.out.println("""
        |=============================================================|
        |               FREDDY FAZBEAR'S PIZZERIA                     |
        |=============================================================|
        |                       ADD PIZZA                             |
        |-------------------------------------------------------------|
        | Kitchen Notice:                                             |
        | All pizzas are prepared fresh. Some even too fresh...       |
        ---------------------------------------------------------------
        """);

        int size = pickSize();

        String crust = pickCrust();

        boolean isStuffed = askYesNo(" Would you like stuffed crust? Y/N: ");

        System.out.println("---------------------------------------------------------------");

        Pizza newPizza = new Pizza("Freddy Fazbear's Custom Pizza", size, crust, isStuffed);
        addMeats(newPizza);// handles all meat
        addCheese(newPizza);// handles all cheese
        addRegularToppings(newPizza);
        addSauce(newPizza);
        currentOrder.addProduct(newPizza);

    }

    private int pickSize() {
        int size = 0;

        while (size < 8) {
            System.out.println("""
                    |                                                             |
                    | What size would you like?                                   |
                    | 1) Size 8"                                                  |
                    | 2) Size 12"                                                 |
                    | 3) Size 16"                                                 |
                    """);
            String userChoice = askForText(" Choose size: ");

            switch (userChoice) {
                case "1" -> size = 8;
                case "2" -> size = 12;
                case "3" -> size = 16;
                default -> System.out.println("Please select the right choice");
            }
        }
        return size;
    }

    private String pickCrust() {
        String crust = null;

        while (crust == null) {
            System.out.println("""
                    |                                                             |
                    | What crust would you like?                                  |
                    | 1) Thin                                                     |
                    | 2) Regular                                                  |
                    | 3) Thick                                                    |
                    | 4) Cauliflower                                              |
                    """);
            String userChoice = askForText(" Choose: ");

            switch (userChoice) {
                case "1" -> crust = "Thin";
                case "2" -> crust = "Regular";
                case "3" -> crust = "Thick";
                case "4" -> crust = "Cauliflower";
                default -> System.out.println("Please select the right choice");
            }
        }
        return crust;
    }

    private void addMeats(Pizza pizza) { // private method because only the class need to know about it
        boolean addingMeats = true;

        while (addingMeats) {
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
            String userChoice = askForText("Choose: ");

            switch (userChoice) {

                case "1" -> addPremiumTopping(new Meat("Pepperoni"), pizza);
                case "2" -> addPremiumTopping(new Meat("Sausage"), pizza);
                case "3"-> addPremiumTopping(new Meat("Ham"), pizza);
                case "4" -> addPremiumTopping(new Meat("Bacon"), pizza);
                case "5" -> addPremiumTopping(new Meat("Chicken"), pizza);
                case "6" -> addPremiumTopping(new Meat("Meatball"), pizza);
                case "0"-> addingMeats = false;
                default -> System.out.println("Please select a valid option");
            }
        }
    }

    private void addCheese(Pizza pizza) { //private method because only the class need to know about it
        boolean addingCheese = true;

        while (addingCheese) {
            System.out.println("""
                    Add a cheese:
                    1) Mozzarella
                    2) Parmesan
                    3) Ricotta
                    4) Goat Cheese
                    5) Buffalo
                    0) Done
                    """);
            String userChoice = askForText("Choose: ");

            switch (userChoice) {

                case "1" -> addPremiumTopping(new Cheese("Mozzarella"), pizza);
                case "2" -> addPremiumTopping(new Cheese("Parmesan"), pizza);
                case "3" -> addPremiumTopping(new Cheese("Ricotta"), pizza);
                case "4" -> addPremiumTopping(new Cheese("Goat Cheese"), pizza);
                case "5" -> addPremiumTopping(new Cheese("Buffalo Cheese"), pizza);
                case "0" -> addingCheese = false;
                default -> System.out.println("Please select a valid option");
            }
        }
    }

    private void addRegularToppings(Pizza pizza) {
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
            String userChoice = askForText("Choose: ");

            switch (userChoice) {
                case "1" -> pizza.addTopping(new RegularTopping("Onions"));
                case "2" -> pizza.addTopping(new RegularTopping("Mushrooms"));
                case "3" -> pizza.addTopping(new RegularTopping("Bell Peppers"));
                case "4" -> pizza.addTopping(new RegularTopping("Olives"));
                case "5" -> pizza.addTopping(new RegularTopping("Tomatoes"));
                case "6" -> pizza.addTopping(new RegularTopping("Spinach"));
                case "7" -> pizza.addTopping(new RegularTopping("Basil"));
                case "8" -> pizza.addTopping(new RegularTopping("Pineapple"));
                case "9" -> pizza.addTopping(new RegularTopping("Anchovies"));
                case "0" -> addingTopping = false;
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
        String userChoice = askForText("Choose: ");

        switch (userChoice) {
            case "1" -> pizza.addSauce("Marinara");
            case "2" -> pizza.addSauce("Alfredo");
            case "3" -> pizza.addSauce("Pesto");
            case "4" -> pizza.addSauce("BBQ");
            case "5" -> pizza.addSauce("Buffalo");
            case "6" -> pizza.addSauce("Olive Oil");
            default -> System.out.println("Please select a valid option");
        }

    }

    private void addDrink() {
        String size = pickDrinkSize();
        String flavor = pickDrinkFlavor();

        Drink newDrink = new Drink(size + " " + flavor, size, flavor);
        currentOrder.addProduct(newDrink);
    }

    private String pickDrinkSize () {
        String size = null;

        while (size == null) {
            System.out.println("""
                    Choose a size:
                    1) Small
                    2) Medium
                    3) Large
                    """);
            String userChoice = askForText("Choose: ");

            switch (userChoice) {
                case "1" -> size = "Small";
                case "2" -> size = "Medium";
                case "3" -> size = "Large";
                default -> System.out.println("Please select the right choice");
            }

        }
        return size;
    }

    private String pickDrinkFlavor() {
        String flavor = null;

        while (flavor == null) {
            System.out.println("""
                    Choose a flavor:
                    1) Faz-Fizz Cola: Classic cola with vanilla and caramel.
                    
                    2) Bonnie Berry Punch: Blue raspberry, blackberry, and lemonade.
                    
                    3) Chica's Pink Lemonade: Strawberry lemonade with a sweet candy finish.
                    
                    4) Foxy's Black Cherry Cola: Dark cherry cola with lime.
                    
                    5) Golden Cup Mystery Soda: Random mystery flavor.
                    
                    """);
            String userChoice = askForText("Choose: ");

            switch (userChoice) {
                case "1" -> {
                    flavor = "Faz-Fizz Cola";
                    System.out.println("The bubbles keep rising after the cup is empty 🫧🥤");
                }
                case "2" -> {
                    flavor = "Bonnie Berry Punch";
                    System.out.println("Stains your tongue blue. Stains your dreams too 🐰");
                }
                case "3" -> {
                    flavor = "Chica's Pink Lemonade";
                    System.out.println("Served with a smile you did not ask for 🐥");
                }
                case "4" -> {
                    flavor = "Foxy's Black Cherry Cola";
                    System.out.println("Best enjoyed near Pirate Cove. Never go there alone 🦊");
                }
                case "5" -> {
                    flavor = "Golden Cup Mystery Soda";
                    System.out.println("Weird... The system says you ordered it before.");
                }
                default -> System.out.println("Please select the right choice");
            }
        }
        return flavor;
    }

    private void addGarlicKnots() {
        System.out.println("""
                      Backstage Garlic Knots
                Warm garlic knots served with marinara.
                Please do not ask why the box is sealed.
                """);
        int quantity = 0;
        while (quantity < 1){

            String quantityInput = askForText("\nHow many Garlic Knots would you like?: ");
            try {
                quantity = Integer.parseInt(quantityInput);

                if (quantity < 1) {
                    System.out.println("Please enter at least 1.");
                    quantity = 0;
                }
            } catch (NumberFormatException e) {
                System.out.println("We don't reconigze this amount...");
            }
        }
        GarlicKnots garlicKnots = new GarlicKnots("Backstage Garlic Knots", quantity);

        currentOrder.addProduct(garlicKnots);
    }

    private boolean checkout() {
        if (currentOrder.getProducts().isEmpty()) {
            System.out.println("Your order is empty.");
            return false;
        }
        for (Product product : currentOrder.getProducts()) {
            System.out.println(product);
        }
        System.out.printf("Total: $%.2f", currentOrder.calculateTotal());

        boolean confirm = askYesNo("\nWould you like to confirm your order? Y/N (There will be no way back 🐻)");
        if (confirm) {
            ReceiptManager.saveReceipt(currentOrder);
            // back home
            return true;
        } else {
            // cancel
            // back home
            return false;
        }
    }

// helper methods

    private String askForText(String prompt) {
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
