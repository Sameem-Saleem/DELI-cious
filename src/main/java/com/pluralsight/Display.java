package com.pluralsight;

import java.io.IOException;
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
        Order currentOrder = new Order();
        boolean running = true;
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
            int signatureSandwich = promptInt("1) BLT\n2) Philly Cheese\n3) Sameem's Subway\n4) Year Up Special");
            switch (signatureSandwich) {
                case 1 -> order.add(new BLT());
                case 2 -> order.add(new PhillyCheeseSteak());
                case 3 -> order.add(new SameemsSub());
                case 4 -> order.add(new YearUpSpecial());
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
        int bread = promptInt("Please choose your bread:\n1) White\n2) Wheat\n3) Rye\n4) Wrap");
        int size = promptInt("Please choose your size:\n1) 4\"\n2) 8\"\n3) 12\"");
        ArrayList<String> toppings = new ArrayList<>();
        while (running) {
            int choice = promptInt("Add toppings:\n1) Add Meat\n2) Add Cheese\n3) Add Other Toppings\n4) Select Sauces\n5) Add Sides\n0) Finish Sandwich");
            switch (choice) {
                case 1 -> promptAdd(Sandwich.MEATS, toppings);
                case 2 -> promptAdd(Sandwich.CHEESES, toppings);
                case 3 -> promptAdd(Sandwich.VEGGIES, toppings);
                case 4 -> promptAdd(Sandwich.SAUCES, toppings);
                case 5 -> promptAdd(Sandwich.EXTRAS, toppings);
                case 0 -> running = false;
            }
        }
        int extraMeat = promptInt("Would you like extra meat?:\n1) Yes\n2) No");
        int extraCheese = promptInt("Would you like extra cheese?:\n1) Yes\n2) No");
        int toast = promptInt("Would you like it toasted?:\n1) Yes\n2) No");
        return new Sandwich(bread, size, toppings, extraMeat, extraCheese, toast);
    }
    /**
     * Prompts the user to select one of the toppings in the {@code selection} parameter, then returns adds that topping.
     * @param selection What toppings to prompt the user to select.
     */
    public static void promptAdd(String[] selection, ArrayList<String> toppings) {
        StringBuilder promptString = new StringBuilder();
        for (int i = 0; i < selection.length; i++) {
            promptString.append(i + 1).append(") ").append(selection[i]).append("\n");
        }
        int choice = promptInt(String.valueOf(promptString));
        toppings.add(selection[choice - 1]);
    }

    /**
     * Checkout option, provides terminal interface for saving data file.
     */
    public static void checkout(Order order) throws IOException {
        int confirm = promptInt("1) Confirm\n2) Cancel");
        if (confirm == 1) {
            order.printReceipt();
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
