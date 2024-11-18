package com.pluralsight;

import java.util.ArrayList;

public class Sandwich implements Orderable {
    public static final String[] MEATS = new String[]{"steak", "ham", "salami", "chicken", "roast beef", "bacon"};
    public static final String[] CHEESES = new String[]{"american", "provolone", "cheddar", "swiss"};
    public static final String[] VEGGIES = new String[]{"lettuce", "peppers", "onions", "tomatoes", "jalapenos", "cucumbers", "pickles", "guacamole", "mushrooms"};
    public static final String[] SAUCES = new String[]{"mayo", "mustard", "ketchup", "ranch", "thousand islands", "vinaigrette"};
    public static final String[] EXTRAS = new String[]{"au jus", "sauce"};
    private final Boolean extraMeat;
    private final Boolean extraCheese;
    private final Boolean toasted;
    private final ArrayList<String> toppings;
    private Bread bread;
    private Inches inches;

    /**
     * Constructs Sandwich object with topping String list, int for bread, inches, extraMeat, extraCheese, and toasted.
     *
     * @param bread       Represents the type of bread, 1 = white, 2 = wheat, 3 = rye, 4 = wrap.
     * @param inches      Represents the length, 1 = 4", 2 = 8", 3 = 12".
     * @param extraMeat   Represents whether to add extra meat, 1 = yes, 2 = no.
     * @param extraCheese Represents whether to add extra cheese, 1 = yes, 2 = no.
     * @param toasted     Represents whether to toast, 1 = yes, 2 = no.
     */
    public Sandwich(int bread, int inches, ArrayList<String> toppings, int extraMeat, int extraCheese, int toasted) {
        switch (bread) {
            case 1 -> this.bread = Bread.WHITE;
            case 2 -> this.bread = Bread.WHEAT;
            case 3 -> this.bread = Bread.RYE;
            case 4 -> this.bread = Bread.WRAP;
        }
        switch (inches) {
            case 1 -> this.inches = Inches.FOUR;
            case 2 -> this.inches = Inches.EIGHT;
            case 3 -> this.inches = Inches.TWELVE;
        }
        this.extraCheese = extraCheese == 1;
        this.extraMeat = extraMeat == 1;
        this.toasted = toasted == 1;
        this.toppings = toppings;
    }

    /**
     * Returns a double representing the total cost of the sandwich.
     *
     * @return Returns the sum of all toppings and customizations, accounting for the length of the sandwich.
     */
    public double getPrice() {
        double totalPrice = this.inches.getPrice();
        double toppingMultiplier = this.inches.getMultiplier();
        for (String topping : this.toppings) {
            switch (topping) {
                case "steak", "ham", "salami", "roast beef", "chicken", "bacon" -> totalPrice += toppingMultiplier;
                case "american", "provolone", "cheddar", "swiss" -> totalPrice += 0.75 * toppingMultiplier;
            }
        }
        if (this.extraCheese) {
            totalPrice += 0.30 * toppingMultiplier;
        }
        if (this.extraMeat) {
            totalPrice += 0.50 * toppingMultiplier;
        }
        return totalPrice;
    }

    /**
     * Builds a {@code String} with additional lines for each of the customizations.
     *
     * @return Returns a {@code String} representation of the sandwich
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(this.inches + " " + this.bread + " Sandwich\n");
        for (String topping : this.toppings) {
            result.append(" - ").append(topping).append("\n");
        }
        if (this.toasted) {
            result.append(" - ").append("toasted\n");
        }
        return result.substring(0, result.length() - 1);
    }

    enum Bread {
        WHITE, WHEAT, RYE, WRAP;

        @Override
        public String toString() {
            return this.name();
        }
    }

    enum Inches {
        FOUR(5.50, "4\"", 1), EIGHT(7.00, "8\"", 2), TWELVE(8.50, "12\"", 3);
        private final String displayName;
        private final double price;
        private final double multiplier;

        Inches(double price, String displayName, double multiplier) {
            this.displayName = displayName;
            this.price = price;
            this.multiplier = multiplier;
        }

        public double getPrice() {
            return this.price;
        }

        public double getMultiplier() {
            return this.multiplier;
        }

        @Override
        public String toString() {
            return this.displayName;
        }
    }
}
