package com.pluralsight;

import java.util.ArrayList;

public class Sandwich implements Orderable {
    private final Bread bread;
    private final Inches inches;
    private final Boolean extraMeat;
    private final Boolean extraCheese;
    private final Boolean toasted;
    private final ArrayList<String> toppings;

    public Sandwich(int bread, int inches, ArrayList<String> toppings, int extraMeat, int extraCheese, int toasted) {
        switch (bread) {
            case 1 -> this.bread = Bread.WHITE;
            case 2 -> this.bread = Bread.WHEAT;
            case 3 -> this.bread = Bread.RYE;
            default -> this.bread = Bread.WRAP;
        }
        switch (inches) {
            case 1 -> this.inches = Inches.FOUR;
            case 2 -> this.inches = Inches.EIGHT;
            default -> this.inches = Inches.TWELVE;
        }
        this.extraCheese = extraCheese == 1;
        this.extraMeat = extraMeat == 1;
        this.toasted = toasted == 1;
        this.toppings = toppings;
    }

    public double getPrice() {
        double totalPrice = this.inches.getPrice();
        double toppingMultiplier = this.inches.getMultiplier();
        for (String topping : this.toppings) {
            switch (topping) {
                case "steak", "ham", "salami", "roast beef", "chicken", "bacon" -> totalPrice += toppingMultiplier;
                case "american", "provolone", "cheddar", "swiss" -> totalPrice += 0.75 * toppingMultiplier;
            }
        }
        totalPrice += this.extraCheese ? 0.30 * toppingMultiplier : 0;
        totalPrice += this.extraMeat ? 0.50 * toppingMultiplier : 0;
        return totalPrice;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(this.inches + " " + this.bread + " Sandwich\n");
        for (String topping : this.toppings) {
            result.append(" - ").append(topping).append("\n");
        }
        return result.toString().substring(0, result.length() - 1);
    }

    enum Sauce {
        MAYO, MUSTARD, KETCHUP, RANCH, THOUSAND_ISLAND, VINAIGRETTE;

        @Override
        public String toString() {
            return this.name();
        }
    }

    enum Side {
        AU_JUS, SAUCE;

        @Override
        public String toString() {
            return this.name();
        }
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
