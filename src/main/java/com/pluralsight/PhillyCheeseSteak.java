package com.pluralsight;

import java.util.ArrayList;

public class PhillyCheeseSteak extends Sandwich {
    public PhillyCheeseSteak() {
        super("white", 8, getToppings(), false, false, true);
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
