package com.pluralsight;

import java.util.ArrayList;

public class Order {
    private ArrayList<Orderable> cart = new ArrayList<>();

    public void add(Orderable item) {
        cart.add(item);
    }

    public ArrayList<Orderable> getCart() {
        return new ArrayList<>(cart);
    }
}
