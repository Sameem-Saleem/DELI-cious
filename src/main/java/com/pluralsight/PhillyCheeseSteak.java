package com.pluralsight;

import java.util.ArrayList;

public class PhillyCheeseSteak extends Sandwich {
    public PhillyCheeseSteak() {
        super(1, 2, getToppings(), 2, 2, 1);
    }

    private static ArrayList<String> getToppings() {
        ArrayList<String> toppings = new ArrayList<>();
        toppings.add("steak");
        toppings.add("american");
        toppings.add("peppers");
        toppings.add("mayo");
        return toppings;
    }
}
