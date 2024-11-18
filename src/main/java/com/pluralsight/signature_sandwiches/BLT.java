package com.pluralsight.signature_sandwiches;

import com.pluralsight.Sandwich;

import java.util.ArrayList;

public class BLT extends Sandwich {
    /**
     * Constructs BLT instance with predefined parameters.
     */
    public BLT() {
        super(1, 2, getToppings(), 2, 2, 1);
    }

    /**
     * Static method to initialize BLT instance with toppings.
     */
    private static ArrayList<String> getToppings() {
        ArrayList<String> toppings = new ArrayList<>();
        toppings.add("bacon");
        toppings.add("cheddar");
        toppings.add("lettuce");
        toppings.add("tomato");
        toppings.add("ranch");
        return toppings;
    }
}
