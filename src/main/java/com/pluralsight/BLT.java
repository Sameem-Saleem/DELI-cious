package com.pluralsight;

import java.util.ArrayList;

public class BLT extends Sandwich {
    public BLT() {
        super("white", 8, getToppings(), false, false, true);
    }

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
