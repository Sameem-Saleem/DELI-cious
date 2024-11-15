package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Display {
    /**
     * Scanner for user input.
     */
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Home screen, provides terminal interface to create orders or exit program.
     */
    public static void homeScreen() throws IOException {
        boolean running = true;
        while (running) {
            int choice = promptInt("1) New Order\n0) Exit");
            switch (choice) {
                case 1 -> newOrder();
                case 0 -> running = false;
            }
        }
        scanner.close();
    }

    /**
     * Order screen, provides terminal interface for adding items to purchase.
     */
    public static void newOrder() throws IOException {
        boolean running = true;
        Order currentOrder = new Order();
        while (running) {
            System.out.print(currentOrder.getReceipt());
            int choice = promptInt("1) Add Sandwich\n2) Add Drink\n3) Add Chips\n4) Checkout\n0) Cancel Order");
            switch (choice) {
                case 1 -> addSandwich(currentOrder);
                case 2 -> addDrink(currentOrder);
                case 3 -> addChips(currentOrder);
                case 4 -> {
                    checkout(currentOrder);
                    running = false;
                }
                case 0 -> running = false;
            }
        }
    }

    /**
     * Drink adding screen, provides terminal interface for user to choose drinks.
     */
    public static void addDrink(Order order) {
        order.add(new Drink(promptInt("1) Coca Cola\n2) Mountain Dew\n3) Pepsi\n4) Fanta"), promptInt("1) Small\n2) Medium\n3) Large")));
    }

    /**
     * Chips adding screen, provides terminal interface for user to add chips.
     */
    public static void addChips(Order order) {
        order.add(new Chips(promptInt("1) Takis\n2) Doritos\n3) Lays")));
    }

    /**
     * Sandwich adding screen, provides terminal interface for user to choose signature sandwich.
     */
    public static void addSandwich(Order order) {
        int sandwichOption = promptInt("1) Signature Sandwiches\n2) Custom Sandwich");
        if (sandwichOption == 1) {
            int signatureSandwich = promptInt("1) BLT\n2) Philly Cheese");
            switch (signatureSandwich) {
                case 1 -> order.add(new BLT());
                case 2 -> order.add(new PhillyCheeseSteak());
            }
        } else {
            order.add(createCustomSandwich());
        }
    }

    /**
     * Directs user in creating custom sandwich through terminal interface, returning the sandwich object.
     */
    public static Sandwich createCustomSandwich() {
        boolean running = true;
        int bread = promptInt("Please choose your bread:\n1)White\n2)Wheat\n3)Wrap");
        int size = promptInt("Please choose your size:\n1)4\"\n2)8\"\n3)12\"");
        ArrayList<String> toppings = new ArrayList<>();
        while (running) {
            int choice = promptInt("Add toppings:\n1) Add Meat\n2) Add Cheese\n3) Add Other Toppings\n4) Select Sauces\n5) Add Sides\n0) Cancel Order");
            switch (choice) {
                case 1 -> addMeat(toppings);
                case 2 -> addCheese(toppings);
                case 3 -> addToppings(toppings);
                case 4 -> selectSauces(toppings);
                case 5 -> addSides(toppings);
                case 0 -> running = false;
            }
        }
        int extraMeat = promptInt("Would you like extra meat?:\n1) Yes\n2) No");
        int extraCheese = promptInt("Would you like extra cheese?:\n1) Yes\n2) No");
        int toast = promptInt("Would you like it toasted?:\n1) Yes\n2) No");
        return new Sandwich(bread, size, toppings, extraMeat, extraCheese, toast);
    }

    /**
     * Opens a selection of meats to the user to add to the input ArrayList
     */
    public static void addMeat(ArrayList<String> toppings) {
        int choice = promptInt("1) Steak\n2) Ham\n3) Salami\n4) Chicken\n5) Roast Beef\n6) Bacon");
        switch (choice) {
            case 1 -> toppings.add("steak");
            case 2 -> toppings.add("ham");
            case 3 -> toppings.add("salami");
            case 4 -> toppings.add("chicken");
            case 5 -> toppings.add("roast beef");
            case 6 -> toppings.add("bacon");
        }
    }

    /**
     * Opens a selection of cheese to the user to add to the input ArrayList
     */
    public static void addCheese(ArrayList<String> toppings) {
        int choice = promptInt("1) American\n2) Provolone\n3) Cheddar\n4) Swiss");
        switch (choice) {
            case 1 -> toppings.add("american");
            case 2 -> toppings.add("provolone");
            case 3 -> toppings.add("cheddar");
            case 4 -> toppings.add("swiss");
        }
    }

    /**
     * Opens a selection of toppings to the user to add to the input ArrayList
     */
    public static void addToppings(ArrayList<String> toppings) {
        int choice = promptInt("1) American\n2) Provolone\n3) Cheddar\n4) Swiss");
        switch (choice) {
            case 1 -> toppings.add("lettuce");
            case 2 -> toppings.add("peppers");
            case 3 -> toppings.add("onions");
            case 4 -> toppings.add("tomatoes");
            case 5 -> toppings.add("jalapenos");
            case 6 -> toppings.add("cucumbers");
            case 7 -> toppings.add("pickles");
            case 8 -> toppings.add("guacamole");
            case 9 -> toppings.add("mushrooms");
        }
    }

    /**
     * Opens a selection of sauces to the user to add to the input ArrayList
     */
    public static void selectSauces(ArrayList<String> toppings) {
        int choice = promptInt("1) Mayo\n2) Mustard\n3) Ketchup\n4) Ranch\n5) Thousand Islands\n6) Vinaigrette");
        switch (choice) {
            case 1 -> toppings.add("mayo");
            case 2 -> toppings.add("mustard");
            case 3 -> toppings.add("ketchup");
            case 4 -> toppings.add("ranch");
            case 5 -> toppings.add("thousand islands");
            case 6 -> toppings.add("vinaigrette");
        }
    }

    /**
     * Opens a selection of sides to the user to add to the input ArrayList
     */
    public static void addSides(ArrayList<String> toppings) {
        int choice = promptInt("1) Au Jus\n2) Sauce");
        switch (choice) {
            case 1 -> toppings.add("au jus");
            case 2 -> toppings.add("sauce");
        }
    }

    /**
     * Ledger menu loop, provides terminal interface for viewing data file.
     */
    public static void checkout(Order order) throws IOException {
        int confirm = promptInt("1) Confirm\n2) Cancel");
        if (confirm == 1) {
            String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
            String currentTime = LocalTime.now().format(DateTimeFormatter.ofPattern("hhmmss"));
            String fileName = "receipts/" + currentDate + "-" + currentTime + ".txt";
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            writer.write(order.getReceipt());
            writer.newLine();
            writer.close();
        }
    }

    /**
     * Prompts the user with the {@code prompt} parameter, then returns their {@code int} input.
     *
     * @param prompt What to prompt the user
     * @return User {@code int} input.
     */
    public static int promptInt(String prompt) {
        System.out.println(prompt);
        return scanner.nextInt();
    }
}
