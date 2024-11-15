package com.pluralsight;

import java.util.ArrayList;

public class BLT extends Sandwich {
    public BLT() {
        super(1, 2, getToppings(), 2, 2, 1);
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
