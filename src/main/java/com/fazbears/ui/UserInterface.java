package com.fazbears.ui;

import com.fazbears.data.ReceiptManager;
import com.fazbears.model.*;

import java.util.Scanner;

public class UserInterface {

    private final Scanner input;
    private Order currentOrder;

    public UserInterface() {
        this.input = new Scanner(System.in);
    }

    //skeletons
    public void start() {
        loadingBox();


        System.out.println("""
                  ==========================================================
                                 FREDDY FAZBEAR'S PIZZERIA
                  ==========================================================
                                     ⣎⠉⠉⠉⠉⠉⠉⠉⠉⣱⠀⠀⠀⠀⠀⠀⠀⠀⠀          ⠀
                                      ⢻⠀⠀⠀⠀⠀⠀⠀⠀⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                                    ⢰⠚⠒⠒⠒⠒⠒⠒⠒⠒⠓⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀     Hi there!
                           ⢀⣀⣀⣀⠀⢠⡤⢄⣸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣇⡠⢤⡄⠀⣀⣀⣀⡀    / I'm Freddy!
                          ⡰⠕⠀⠐⠂⠍⡆⠙⣭⣛⡀⠤⠤⠤⠤⠤⠤⠤⠄⢐⣛⣭⠋⢰⡩⠐⠐⠫⢆
                         ⢣⢄⠀⠀⢀⢠⢛⠞⠁⠀⠉⠉⠁⠒⠒⠒⠒⠈⠉⠉⠀⠈⠳⡛⡄⡀⠀⠀⡠⡜
                          ⠳⣕⠀⣰⣻⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀   ⠀⠙⣝⣆⠀⣪⠞⠀
                             ⠉⢠⠇⠀⠀⠀⣀⣀⣀⠀⠀⠀⠀⠀⠀⣀⣀⣀⠀⠀⠀⠸⡄⠉⠀⠀⠀
                              ⢸⠀⠀⢠⡾⠿⠿⠿⣿⣄⠀⠀⣠⣿⠿⠿⠿⢷⡀⠀⠀⡇⠀⠀⠀⠀
                              ⢸⠀⠀⠈⢀⣶⠛⠛⢦⠙⠀⠐⠋⡶⠛⠛⣷⡀⠀⠀⠀⡇⠀⠀⠀⠀
                              ⡸⠃⠀⠀⠸⣷⡈⡃⣸⠇⠀⠀⠸⣇⢹⠁⣾⠇⠀⠀⠘⢇⠀⠀⠀⠀
                            ⢸⠁⠀⠀⠀⢀⣩⠿⢿⡭⠤⢶⣶⣤⣭⡿⠿⣉⣀⠀⠀⠀  ⠈⡆⠀⠀⠀
                             ⠘⢆⡀⢀⡞⠁⠀⠀⠀⠙⠛⠿⠿⠛⠋⠀⠀⠀⠈⢳⡀⠀⡰⠃⠀⠀⠀
                               ⢹⢾⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀   ⢠⡗ ⡏⠀⠀⠀⠀⠀
                               ⠸⡄⢷⣀⠀⠀⠀⠀⠀ ⣠⣄⠀⠀⠀⠀⠀  ⢀⡾⢠⠃⠀⠀⠀⠀⠀
                                ⢣⠈⠫⣹⡒⠚⢉⠉⢉⡉⠉⣉⠓⢒⣏⠝⠁⡞⠀⠀⠀⠀⠀⠀
                                 ⠳⡀⠈⠙⠒⠛⠤⠼⠧⠤⠛⠒⠋⠁⣀⠞⠁⠀⠀⠀⠀⠀⠀
                                  ⠈⠓⠦⠤⣤⣀⣠⣄⣀⣠⠤⠴⠚⠁⠀⠀⠀⠀⠀⠀⠀⠀
                         Family Fun, Fresh Pizza, Forever Memories
                 -------------------------------------------------------------
                | House Notice:                                               |
                | Birthday parties must be scheduled before dark.             |
                 -------------------------------------------------------------""");


        boolean isRunning = true;

        while (isRunning) {
            System.out.println("""
                      ===========================================================
                    |                FREDDY FAZBEAR'S PIZZERIA                    | \s
                    |                    Ready to order?                          |             \s
                    |-------------------------------------------------------------|
                    | 1) New Order                                                |
                    | 0) Exit                                                     |
                     ============================================================
                    \s""");
            String userChoice = askForText(" Make your selection: ");
            if (userChoice.isBlank()) {
                continue;
            }

            switch (userChoice) {
                case "1" -> displayOrderScreen();
                case "0" -> {
                    closingScreen();
                    isRunning = false;
                }
                default -> printInvalidChoice();
            }
        }
    }

    public void displayOrderScreen() {
        currentOrder = new Order();

        boolean isRunning = true;
        System.out.println("""
                 =============================================================
                |                 FREDDY FAZBEAR'S PIZZERIA                   | \s
                |                  Family Fun. Fresh Pizza.                   |
                |=============================================================|
                |                          NEW ORDER                          |\s
                |-------------------------------------------------------------|
                | House Notice:                                               |
                | Please remain with your party until your order is complete. |\s
                |                                                             |""");


        while (isRunning) {
            System.out.println("""
                     -------------------------------------------------------------
                    | 1) Build Your Own Pizza                                     |
                    | 2) Signature Pizzas                                         |
                    | 3) Add Drink                                                |\s
                    | 4) Add Garlic Knots                                         |
                    | 5) Remove Item                                              |
                    | 6) Checkout                                                 | \s
                    | 0) Cancel                                                   |
                     -------------------------------------------------------------
                    \s""");
            String userChoice = askForText(" Make your selection: ");

            switch (userChoice) {
                case "1" -> displayBuildYourOwnPizzaScreen();
                case "2" -> displaySignaturePizzaScreen();
                case "3" -> addDrink();
                case "4" -> addGarlicKnots();
                case "5" -> removeItemFromOrder();
                case "6" -> {
                    boolean completed = checkout();
                    if (completed) {
                        isRunning = false;
                    }
                }
                case "0" -> {
                    goingToMainScreen();
                    isRunning = false;
                    currentOrder = null;
                }
                default -> printInvalidChoice();
            }
        }
    }

    private void displaySignaturePizzaScreen() {
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("""
                     =============================================================
                    |                        SIGNATURE PIZZAS                     |
                    |=============================================================|
                    |                                                             |
                    | 1) Freddy's Classic Party Pizza                             |
                    |   12" Regular Crust                                         |
                    |   Pepperoni, Mozzarella, Parmesan, Tomatoes, Basil          |
                    |   Sauce: Marinara                                           |
                    |                                                             |
                    |   Description:                                              |
                    |   A classic birthday-party pizza served the Fazbear way.    |
                    |   House Notice: The first slice is always missing           |
                    |   by the time it reaches the table.                         |
                    |                                                             | \s
                    | 2) Chica's Kitchen Feast                                    |
                    |   16" Thick Crust                                           |
                    |   Chicken, Bacon, Mozzarella, Ricotta                       |
                    |   Onions, Mushrooms, Bell Peppers, Spinach                  |
                    |   Sauce: Alfredo                                            |
                    |                                                             |
                    |   Description:                                              |
                    |   A warm, heavy kitchen favorite with creamy sauce          |
                    |   and extra toppings.                                       |
                    |   House Notice: If you hear singing from the kitchen,       |
                    |   do not sing back.                                         |
                    |                                                             |
                    | 3) Golden Freddy's After-Hours Special                      |
                    |   12" Thin Crust                                            |
                    |   Meatball, Sausage, Mozzarella, Goat Cheese                |\s
                    |   Olives, Mushrooms, Basil                                  |\s
                    |   Sauce: Order and find out...                              | \s
                    |                                                             |  \s
                    |   Description:                                              | \s
                    |   A quiet after-hours pizza with earthy toppings            |
                    |   and a mystery finish.                                     |
                    |   House Notice: The receipt says you ordered this before    |\s
                    |                                                             |
                    | 0) Back                                                     | \s
                     -------------------------------------------------------------
                    \s""");

            String userChoice = askForText(" Make your selection: ");

            switch (userChoice) {
                case "1" -> {
                    customizeSignaturePizza(new FreddysClassicPartyPizza());
                    isRunning = false;
                }
                case "2" -> {
                    customizeSignaturePizza(new ChicasKitchenFeast());
                    isRunning = false;
                }
                case "3" -> {
                    customizeSignaturePizza(new GoldenFreddysAfterHoursSpecial());
                    isRunning = false;
                }
                case "0" -> {
                    goingToMainScreen();
                    isRunning = false;
                }
                default -> printInvalidChoice();
            }
        }
    }

    private void displayBuildYourOwnPizzaScreen() {

        System.out.println("""
                 =============================================================
                |               FREDDY FAZBEAR'S PIZZERIA                     |
                |=============================================================|
                |                       ADD PIZZA                             |
                |-------------------------------------------------------------|
                | Kitchen Notice:                                             |
                | All pizzas are prepared fresh. Some even too fresh...       |
                |                                                             |
                """);


        int size = pickSize();

        String crust = pickCrust();

        boolean isStuffed = askYesNo(" Would you like stuffed crust? Y/N: ");

        Pizza newPizza = new Pizza("Freddy Fazbear's Custom Pizza", size, crust, isStuffed);
        addMeats(newPizza);// handles all meat
        addCheese(newPizza);// handles all cheese
        addRegularToppings(newPizza);
        addSauce(newPizza);
        currentOrder.addProduct(newPizza);

    }

    private boolean checkout() {
        System.out.println("""
                ============================================================
                                        CHECKOUT
                ============================================================
                Order Details:
                -------------------------------------------------------------
                """);
        if (currentOrder.isEmpty()) {
            System.out.println(" Your order is empty.");
            return false;
        }
        System.out.println(currentOrder);

        boolean confirm = askYesNo("\nConfirm your order? Y/N (Once the receipt prints, the kitchen remembers): ");
        if (confirm) {
            ReceiptManager.saveReceipt(currentOrder);
            System.out.println("ORDER RECORDED");
            printingReceipt();

            System.out.println("""
            ============================================================
                                CUSTOMER RECEIPT
            ============================================================
            """);

            System.out.println(currentOrder);

            return true;
        } else {
            // back home
            return false;
        }
    }

    private void customizeSignaturePizza(Pizza pizza) {
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("""
                     -------------------------------------------------------------
                    | Customize your Signature Pizza                              |
                    | - 1) Add Toppings                                           |
                    | - 2) Remove Toppings                                        |
                    | - 3) Done (Add to Order)                                    |
                     -------------------------------------------------------------
                    """);
            String userChoice = askForText(" Make your selection: ");

            switch (userChoice) {
                case "1" -> displayAddToppingsMenu(pizza);
                case "2" -> removeToppingFromPizza(pizza);
                case "3" -> {
                    currentOrder.addProduct(pizza);
                    isRunning = false;
                }
                default -> printInvalidChoice();
            }
        }
    }

    private void displayAddToppingsMenu(Pizza pizza) {
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("""
                     -------------------------------------------------------------
                    |  Add toppings for your Signature Pizza                      |
                    |   - 1) Add Meat                                             |
                    |   - 2) Add Cheese                                           |
                    |   - 3) Add Regular Topping                                  |
                    |   - 0) Back                                                 |
                     -------------------------------------------------------------
                    """);
            String userChoice = askForText(" Make your selection: ");

            switch (userChoice) {
                case "1" -> addMeats(pizza);
                case "2" -> addCheese(pizza);
                case "3" -> addRegularToppings(pizza);
                case "0" -> {
                    goingToMainScreen();
                    isRunning = false;
                }
                default -> printInvalidChoice();
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// .pickers

    private int pickSize() {
        int size = 0;

        while (size < 8) {
            System.out.println("""
                     -------------------------------------------------------------
                    | What size would you like?                                   |
                    | 1) Size 8"                                                  |
                    | 2) Size 12"                                                 |
                    | 3) Size 16"                                                 |
                     -------------------------------------------------------------
                    """);
            String userChoice = askForText(" Choose your pizza size: ");

            switch (userChoice) {
                case "1" -> size = 8;
                case "2" -> size = 12;
                case "3" -> size = 16;
                default -> printInvalidChoice();
            }
        }
        return size;
    }

    private String pickCrust() {
        String crust = null;

        while (crust == null) {
            System.out.println("""
                     -------------------------------------------------------------
                    | CRUST                                                       |
                    | What crust would you like?                                  |
                    | 1) Thin                                                     |
                    | 2) Regular                                                  |
                    | 3) Thick                                                    |
                    | 4) Cauliflower                                              |
                     -------------------------------------------------------------
                    """);
            String userChoice = askForText(" Choose: ");

            switch (userChoice) {
                case "1" -> crust = "Thin";
                case "2" -> crust = "Regular";
                case "3" -> crust = "Thick";
                case "4" -> crust = "Cauliflower";
                default -> printInvalidChoice();
            }
        }
        return crust;
    }

    private String pickDrinkSize() {
        String size = null;

        while (size == null) {
            System.out.println("""
                     -------------------------------------------------------------
                    | DRINK SIZE                                                  |
                    | Choose a size:                                              |
                    | 1) Small                                                    |
                    | 2) Medium                                                   |
                    | 3) Large                                                    |
                    -------------------------------------------------------------
                    """);
            String userChoice = askForText(" Choose: ");

            switch (userChoice) {
                case "1" -> size = "Small";
                case "2" -> size = "Medium";
                case "3" -> size = "Large";
                default -> printInvalidChoice();
            }

        }
        return size;
    }

    private String pickDrinkFlavor() {
        String flavor = null;

        while (flavor == null) {
            System.out.println("""
                     -------------------------------------------------------------
                    |                DRINKS: CHOOSE A FLAVOR                      |
                    ===============================================================
                    | 1) Faz-Fizz Cola: Classic cola with vanilla and caramel.    |
                    |                                                             |
                    | 2) Bonnie Berry Punch: Blue raspberry, blackberry,          |
                    |    and lemonade.                                            |
                    |                                                             |
                    | 3) Chica's Pink Lemonade: Strawberry lemonade               |
                    |    with a sweet candy finish.                               |
                    |                                                             |
                    | 4) Foxy's Black Cherry Cola: Dark cherry cola with lime.    |
                    |                                                             |
                    | 5) Golden Cup Mystery Soda: Random mystery flavor.          |
                     -------------------------------------------------------------
                    """);
            String userChoice = askForText(" Choose: ");

            switch (userChoice) {
                case "1" -> {
                    flavor = "Faz-Fizz Cola";
                    System.out.println("\n The bubbles keep rising after the cup is empty 🫧🥤\n");
                }
                case "2" -> {
                    flavor = "Bonnie Berry Punch";
                    System.out.println(" Stains your tongue blue. Stains your dreams too 🐰\n");
                }
                case "3" -> {
                    flavor = "Chica's Pink Lemonade";
                    System.out.println(" Served with a smile you did not ask for 🐥\n");
                }
                case "4" -> {
                    flavor = "Foxy's Black Cherry Cola";
                    System.out.println(" Best enjoyed near Pirate Cove. Never go there alone 🦊\n");
                }
                case "5" -> {
                    flavor = "Golden Cup Mystery Soda";
                    System.out.println(" Weird... The system says you ordered it before.\n");
                }
                default -> printInvalidChoice();
            }
        }
        return flavor;
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// .addMethods()/.removeMethods()

    private void addMeats(Pizza pizza) { // private method because only the class need to know about it
        boolean addingMeats = true;

        while (addingMeats) {
            System.out.println("""
                     -------------------------------------------------------------
                    | MEAT TOPPINGS                                               |
                    | Add a meat:                                                 |
                    | 1) Freddy's Pepperoni                                       |                                           \s
                    | 2) Backstage Sausage                                        |\s
                    | 3) Party Ham                                                |\s
                    | 4) Foxy's Bacon                                             |\s
                    | 5) Chica's Chicken                                          |\s
                    | 6) Parts & Service Meatball                                 |\s
                    | 0) Done                                                     |
                     -------------------------------------------------------------
                    \s""");
            String userChoice = askForText(" Choose: ");

            switch (userChoice) {

                case "1" -> addPremiumTopping(new Meat("Pepperoni"), pizza);
                case "2" -> addPremiumTopping(new Meat("Sausage"), pizza);
                case "3" -> addPremiumTopping(new Meat("Ham"), pizza);
                case "4" -> addPremiumTopping(new Meat("Bacon"), pizza);
                case "5" -> addPremiumTopping(new Meat("Chicken"), pizza);
                case "6" -> addPremiumTopping(new Meat("Meatball"), pizza);
                case "0" -> addingMeats = false;
                default -> printInvalidChoice();
            }
        }
    }

    private void addCheese(Pizza pizza) { //private method because only the class need to know about it
        boolean addingCheese = true;

        while (addingCheese) {
            System.out.println("""
                     -------------------------------------------------------------
                    | CHEESE TOPPINGS:                                            |
                    | Add a cheese:                                               |
                    | 1) Mozzarella                                               |  \s
                    | 2) Parmesan                                                 |  \s
                    | 3) Ricotta                                                  |  \s
                    | 4) Goat Cheese                                              |  \s
                    | 5) Buffalo                                                  |  \s
                    | 0) Done                                                     |
                     -------------------------------------------------------------
                    \s""");
            String userChoice = askForText(" Choose: ");

            switch (userChoice) {

                case "1" -> addPremiumTopping(new Cheese("Mozzarella"), pizza);
                case "2" -> addPremiumTopping(new Cheese("Parmesan"), pizza);
                case "3" -> addPremiumTopping(new Cheese("Ricotta"), pizza);
                case "4" -> addPremiumTopping(new Cheese("Goat Cheese"), pizza);
                case "5" -> addPremiumTopping(new Cheese("Buffalo Cheese"), pizza);
                case "0" -> addingCheese = false;
                default -> printInvalidChoice();
            }
        }
    }

    private void addRegularToppings(Pizza pizza) {
        boolean addingTopping = true;

        while (addingTopping) {
            System.out.println("""
                     -------------------------------------------------------------
                    | OTHER TOPPINGS:                                             |
                    | 1) Onions                                                   |
                    | 2) Mushrooms                                                |
                    | 3) Bell Peppers                                             |
                    | 4) Olives                                                   |
                    | 5) Tomatoes                                                 |
                    | 6) Spinach                                                  |
                    | 7) Basil                                                    |
                    | 8) Pineapple                                                |
                    | 9) Anchovies                                                |
                    | 0) Done                                                     |
                     -------------------------------------------------------------
                    """);
            String userChoice = askForText(" Choose: ");

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
                default -> printInvalidChoice();
            }
        }
    }

    private void addSauce(Pizza pizza) {
        boolean isChoosingSauce = true;

        while (isChoosingSauce) {
            System.out.println("""
                     -------------------------------------------------------------
                    | SAUCES:                                                     |
                    | What sauce would you like on your pizza?                    |
                    | 1) Marinara                                                 |
                    | 2) Alfredo                                                  |
                    | 3) Pesto                                                    |
                    | 4) BBQ                                                      |
                    | 5) Buffalo                                                  |
                    | 6) Olive Oil                                                |
                    | 0) No sauce                                                 |
                     -------------------------------------------------------------
                    """);
            String userChoice = askForText(" Choose: ");

            switch (userChoice) {
                case "1" -> {
                    pizza.addSauce("Marinara");
                    isChoosingSauce = false;
                }
                case "2" -> {
                    pizza.addSauce("Alfredo");
                    isChoosingSauce = false;
                }
                case "3" -> {
                    pizza.addSauce("Pesto");
                    isChoosingSauce = false;
                }
                case "4" -> {
                    pizza.addSauce("BBQ");
                    isChoosingSauce = false;
                }
                case "5" -> {
                    pizza.addSauce("Buffalo");
                    isChoosingSauce = false;
                }
                case "6" -> {
                    pizza.addSauce("Olive Oil");
                    isChoosingSauce = false;
                }
                case "0" -> {
                    System.out.println(" No sauce added.");
                    isChoosingSauce = false;
                }
                default -> printInvalidChoice();
            }
        }
    }

    private void addDrink() {
        String size = pickDrinkSize();
        String flavor = pickDrinkFlavor();

        Drink newDrink = new Drink(size + " " + flavor, size, flavor);
        currentOrder.addProduct(newDrink);
    }


    private void addGarlicKnots() {
        System.out.println("""
                       ---------------------------------------------
                       |          Backstage Garlic Knots           |
                       |  Warm garlic knots served with marinara.  |
                       |  Please do not ask why the box is sealed. |
                       ---------------------------------------------
                """);
        int quantity = 0;
        while (quantity < 1) {

            String quantityInput = askForText("\n How many Garlic Knots would you like?: ");
            try {
                quantity = Integer.parseInt(quantityInput);

                if (quantity < 1) {
                    System.out.println(" \nPlease enter at least 1.");
                    quantity = 0;
                }
            } catch (NumberFormatException e) {
                System.out.println(" \n[!] Quantity must be at least 1. Empty boxes are for lost items only...");
            }
        }
        GarlicKnots garlicKnots = new GarlicKnots("Backstage Garlic Knots", quantity);

        currentOrder.addProduct(garlicKnots);
    }

    private void addPremiumTopping(Topping topping, Pizza pizza) { // refactored premium toppings into one single method
        String question = String.format(" Would you like extra %s? Y/N: ", topping.getName());
        boolean isExtra = askYesNo(question);

        topping.setExtra(isExtra);
        boolean wasAdded = pizza.addTopping(topping);

        if (!wasAdded) {
            System.out.println(" [!] " + topping.getName() + " is already on this pizza.");
        }

    }

    private void removeItemFromOrder() {
        // check if order is empty
        if (currentOrder.getProducts().isEmpty()) {
            System.out.println(" There are no items to remove.");
            return;
        }
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("""
                    ===============================================================
                                           REMOVE ITEM
                    ===============================================================
                    """);

            for (int i = 0; i < currentOrder.getProducts().size(); i++) { //  loop through products list, print each one with a number.
                System.out.println((i + 1) + ") " + currentOrder.getProducts().get(i) + "\n");
                //i + 1 because lists start at 0, but we count from 1 — so product at index 0 shows as 1
            }

            System.out.println("0) Back");

            String userChoice = askForText("\nWhat item would you like to remove? Type 0 to go back: ");
            try {
                if (userChoice.equals("0")) {
                    isRunning = false;
                } else { // convert the userChoice from String to int. subtract 1 because they typed 1 but the list index is 0

                    int index = Integer.parseInt(userChoice) - 1;

                    if (index >= 0 && index < currentOrder.getProducts().size()) { // make sure their number is in range, then grab that product and remove it
                        Product selectedProduct = currentOrder.getProducts().get(index);
                        currentOrder.removeProduct(selectedProduct);

                        System.out.println(" Removed: " + selectedProduct);

                        if (currentOrder.getProducts().isEmpty()) {
                            System.out.println(" \nThe order is empty now...");
                            isRunning = false;
                        }
                    } else {
                        printInvalidChoice();
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println(" Not a number.");
            }
        }
    }

    private void removeToppingFromPizza(Pizza pizza) { // this method takes a Pizza object so it can modify its toppings list directly
        boolean isRemoving = true;
        if (pizza.getToppings().isEmpty()) {
            System.out.println(" There are no toppings to remove.");
            return;
        }

        while (isRemoving) {
            System.out.println(" ------------------------------------------------------------- ");
            for (int i = 0; i < pizza.getToppings().size(); i++) { //  loop through toppings list, print each one with a number.

                System.out.println("| " + (i + 1) + ") " + pizza.getToppings().get(i));
                //i + 1 because lists start at 0 but humans count from 1 — so topping at index 0 shows as 1
            }
            // ask user for choice
            try {
                String userChoice = askForText(" Which to remove? (Type 0 if you don't want any topping removed): ");
                if (userChoice.equals("0")) {
                    isRemoving = false;
                } else { // convert the userChoice from String to int. subtract 1 because they typed 1 but the list index is 0
                    int index = Integer.parseInt(userChoice) - 1;

                    if (index >= 0 && index < pizza.getToppings().size()) { // make sure their number is in range, then grab that topping and remove it
                        pizza.removeTopping(pizza.getToppings().get(index));
                    } else {
                        printInvalidChoice();
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println(" Not a number.");
            }
        }
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// helper methods

    private String askForText(String prompt) {
        System.out.print(prompt);
        String answer = input.nextLine();
        System.out.println();
        return answer;
    }

    private boolean askYesNo(String question) {
        System.out.printf(question);
        String userInput = input.nextLine();
        System.out.println();

        while (!userInput.equalsIgnoreCase("y") && !userInput.equalsIgnoreCase("n")) {
            System.out.printf(question);
            userInput = input.nextLine();
            System.out.println();
        }
        return userInput.equalsIgnoreCase("y");
    }

    private void printInvalidChoice() {
        System.out.println("\n [!] Invalid choice. The kitchen did not understand your order.\n");
    }

    private void pause(int millisecond) {
        try {
            Thread.sleep(millisecond);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void loadingBox() {
        String message = "Fazbear Entertainment Ordering System | Initializing guest menu";
        System.out.println();

        for (int dots = 0; dots <= 3; dots++) {
            String loadingText = message + ".".repeat(dots);

            System.out.printf("\r| %-61s |", loadingText);

            pause(1200);
        }
        System.out.println();
        System.out.println();
    }

    private void goingToMainScreen() {
        String message = " GOING BACK TO PREVIOUS SCREEN";
        System.out.println();

        for (int dots = 0; dots <= 3; dots++) {
            String loadingText = message + ".".repeat(dots);

            System.out.printf("\r| %-59s |", loadingText);

            pause(500);
        }
        System.out.println();
        System.out.println();
    }

    private void printingReceipt() {
        System.out.println();
        String message = "FAZBEAR'S RECEIPT PRINTER WARMING UP";

        for (int dots = 0; dots <= 3; dots++) {
            String loadingText = message + ".".repeat(dots);

            System.out.printf("\r| %-59s |", loadingText);

            pause(500);
        }
        System.out.println();
        System.out.println(" Receipt printed. Please take it before it takes you.");
        System.out.println();
    }


    private void closingScreen() {
        System.out.println("""
                 -----------------------------------------------------------
                |        THANK YOU FOR USING FREDDY FAZBEAR'S APP           |
                |========================================================== |
                |                                                           |
                | Freddy Fazbear's Pizzeria is not responsible for:         |
                | missing items, missing time, missing children,            |
                | unusual dreams, moving animatronics,                      |
                | singing from vents, duplicate family members,             |
                | or memories recovered during dessert.                     |
                |                                                           |
                | Thank you for dining with us.                             |
                |                                                           |
                |              - Freddy, Chica, Bonnie, Foxy                |
                 ===========================================================
                """);

        System.out.println("Please come again.");
        pause(1200);

        System.out.println("You. Always. Do.");

        pause(500);



    }






}
