package com.pluralsight;

import java.util.ArrayList;

public class SameemsSub extends Sandwich {
    public SameemsSub() {
        super(1, 2, getToppings(), 2, 2, 1);
    }

    private static ArrayList<String> getToppings() {
        ArrayList<String> toppings = new ArrayList<>();
        toppings.add("chicken");
        toppings.add("cheddar");
        toppings.add("lettuce");
        toppings.add("au jus");
        return toppings;
    }
}
