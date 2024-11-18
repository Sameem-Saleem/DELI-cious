package com.pluralsight.signature_sandwiches;

import com.pluralsight.Sandwich;

import java.util.ArrayList;

public class SameemsSub extends Sandwich {
    /**
     * Constructs Sameem's Subway instance with predefined parameters.
     */
    public SameemsSub() {
        super(1, 2, getToppings(), 2, 2, 1);
    }

    /**
     * Static method to initialize Sameem's Subway instance with toppings.
     */
    private static ArrayList<String> getToppings() {
        ArrayList<String> toppings = new ArrayList<>();
        toppings.add("chicken");
        toppings.add("cheddar");
        toppings.add("lettuce");
        toppings.add("au jus");
        return toppings;
    }
}
