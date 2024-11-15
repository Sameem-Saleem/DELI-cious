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
     * Iterates through the {@code Orderables} in the {@code cart} and returns a receipt string.
     */
    public String getReceipt() {
        StringBuilder receipt = new StringBuilder();
//        receipt += "___________________________________________\n\n";
//        receipt += "                 DELIcious\n";
//        receipt += "                45 Milk St.\n";
//        receipt += "               855-932-7871\n";
//        receipt += "Guest Check                Individual Order";
//        receipt += "Takeout                           Ticket 13";
//        receipt += "Server : Sameem              Year Up United";
//        receipt += "___________________________________________\n";
        for (Orderable item : cart) {
            receipt.append("$").append(item.getPrice()).append(" - ").append(item).append("\n");
        }
        return receipt.toString();
    }
    /**
     * Returns a copy of the {@code cart}.
     */
    public ArrayList<Orderable> getCart() {
        return new ArrayList<>(cart);
    }
}
