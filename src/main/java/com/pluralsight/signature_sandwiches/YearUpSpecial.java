package com.pluralsight.signature_sandwiches;

import com.pluralsight.Sandwich;

import java.util.ArrayList;

public class YearUpSpecial extends Sandwich {
    /**
     * Constructs Year Up Special instance with predefined parameters.
     */
    public YearUpSpecial() {
        super(1, 2, getToppings(), 2, 2, 1);
    }

    /**
     * Static method to initialize Year Up Special instance with toppings.
     */
    private static ArrayList<String> getToppings() {
        ArrayList<String> toppings = new ArrayList<>();
        toppings.add("bacon");
        toppings.add("bacon");
        toppings.add("bacon");
        toppings.add("bacon");
        toppings.add("ranch");
        return toppings;
    }
}
