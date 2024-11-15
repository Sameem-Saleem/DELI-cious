package com.pluralsight;

import java.util.ArrayList;

public class Sandwich {
    private final String bread;
    private final int inches;
    private final Boolean extraMeat;
    private final Boolean extraCheese;
    private final ArrayList<String> toppings;

    public Sandwich(String bread, int inches, ArrayList<String> toppings, Boolean extraMeat, Boolean extraCheese) {
        this.bread = bread;
        this.inches = inches;
        this.toppings = toppings;
        this.extraMeat = extraMeat;
        this.extraCheese = extraCheese;
    }

    public double getPrice() {
        double totalPrice = 0;
        double toppingMultiplier = (double) this.inches / 4;
        switch (this.inches) {
            case 4 -> totalPrice += 5.50;
            case 8 -> totalPrice += 7.00;
            case 12 -> totalPrice += 8.50;
        }
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
}
