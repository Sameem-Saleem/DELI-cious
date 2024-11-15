package com.pluralsight;

import java.util.ArrayList;

public class Sandwich {
    private final String bread;
    private final int inches;
    private final Boolean extraMeat;
    private final Boolean extraCheese;
    private final Boolean toasted;
    private final ArrayList<String> toppings;

    public Sandwich(String bread, int inches, ArrayList<String> toppings, Boolean extraMeat, Boolean extraCheese, Boolean toasted) {
        this.bread = bread;
        this.inches = inches;
        this.toppings = toppings;
        this.extraMeat = extraMeat;
        this.extraCheese = extraCheese;
        this.toasted = toasted;
    }

    public double getPrice() {
        double totalPrice = this.inches == 4 ? 5.50 : this.inches == 8 ? 7.00 : this.inches == 12 ? 8.50 : 0;
        double toppingMultiplier = (double) this.inches / 4;
        for (String topping : this.toppings) {
            switch (topping) {
                case "steak", "ham", "salami", "roast beef", "chicken", "bacon" -> totalPrice += toppingMultiplier;
                case "american", "provolone", "cheddar", "swiss" -> totalPrice += 0.75 * toppingMultiplier;
            }
        }
        totalPrice += this.extraCheese ? 0.30 * toppingMultiplier : 0;
        totalPrice += this.extraMeat ? 0.50 * toppingMultiplier : 0;
        return this.toasted ? totalPrice * 1.15 : totalPrice;
    }
}
