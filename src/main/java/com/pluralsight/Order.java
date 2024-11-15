package com.pluralsight;

import java.util.ArrayList;

public class Order {
    /**
     * ArrayList holding all orderable items
     */
    private final ArrayList<Orderable> cart = new ArrayList<>();
    /**
     * Adds {@code Orderable} item into cart
     */
    public void add(Orderable item) {
        cart.add(item);
    }
    /**
     * Iterates through the {@code Orderables} in the {@code cart} and returns the sum of their prices.
     */
    public double getPrice() {
        double totalPrice = 0;
        for (Orderable item : cart) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }
    /**
     * Returns a copy of the {@code cart}.
     */
    public ArrayList<Orderable> getCart() {
        return new ArrayList<>(cart);
    }
}
