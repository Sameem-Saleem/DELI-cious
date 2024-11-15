package com.pluralsight;

import java.util.ArrayList;

public class YearUpSpecial extends Sandwich {
    public YearUpSpecial() {
        super(1, 2, getToppings(), 2, 2, 1);
    }

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
