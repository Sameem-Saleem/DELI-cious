package com.pluralsight.signature_sandwiches;

import com.pluralsight.Sandwich;

import java.util.ArrayList;

public class PhillyCheeseSteak extends Sandwich {
    /**
     * Constructs Philly Cheese Steak instance with predefined parameters.
     */
    public PhillyCheeseSteak() {
        super(1, 2, getToppings(), 2, 2, 1);
    }

    /**
     * Static method to initialize Philly Cheese Steak instance with toppings.
     */
    private static ArrayList<String> getToppings() {
        ArrayList<String> toppings = new ArrayList<>();
        toppings.add("steak");
        toppings.add("american");
        toppings.add("peppers");
        toppings.add("mayo");
        return toppings;
    }
}
