package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Order {
    /**
     * Double to String formatter for prices to ensure 0.00 format.
     */
    private static final DecimalFormat df = new DecimalFormat("0.00");
    /**
     * ArrayList holding all orderable items
     */
    private final ArrayList<Orderable> cart = new ArrayList<>();

    /**
     * Adds {@code Orderable} item into cart
     *
     * @param item Object implementing {@code Orderable} interface to add to cart.
     */
    public void add(Orderable item) {
        cart.add(item);
    }

    /**
     * Iterates through the {@code Orderables} in the {@code cart} and returns a receipt string. The string contains the item names, item prices, and total price.
     */
    public String getReceipt() {
        StringBuilder receipt = new StringBuilder();
        receipt.append("___________________________________________\n\n                 DELIcious\n                45 Milk St.\n               855-932-7871\n Guest Check                Individual Order\nTakeout                           Ticket 13\n Server : Sameem              Year Up United\n___________________________________________\n");
        double totalPrice = 0;
        // Adding item name/details and price to terminal receipt
        for (Orderable item : cart) {
            totalPrice += item.getPrice();
            receipt.append("$").append(df.format(item.getPrice())).append(" - ").append(item).append("\n");
        }
        // Adding total cost to the terminal receipt
        receipt.append("___________________________________________\n                        Check Total   $").append(df.format(totalPrice)).append("\n___________________________________________\n");
        return receipt.toString();
    }

    /**
     * Iterates through the {@code Orderables} in the {@code cart} and exports/saves an HTML document. The document contains the time, date, item names, item prices, and total price.
     *
     * Saves the document with the date and time as name, yyyyMMddhhmmss.html.
     */
    public void printReceipt() throws IOException {
        // Create file with appropriate name, current yyyyMMddhhmmss.html by getting the date and time
        String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        String currentTime = LocalTime.now().format(DateTimeFormatter.ofPattern("hhmmss"));
        String fileName = "receipts/" + currentDate + "-" + currentTime + ".html";
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));

        // Getting the date and time to add to the HTML
        StringBuilder receipt = new StringBuilder();
        String dateString = LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yy"));
        String timeString = LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm"));
        // Adding date and time to HTML
        receipt.append("<!DOCTYPE html><html lang=\"en\"><head><meta charset=\"UTF-8\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"><style>h1, h2 {padding: 0;margin: 0;}.split {display:flex;justify-content: space-between;width: 95%;}</style>\n</head><body style=\"background-color: black; display:flex; justify-content: center;\";><div style=\"background-color: white; width:40rem; padding-top: 4rem; padding-bottom: 12rem; display:flex; justify-content: center; flex-direction:column; align-items: center;\"><h1>DELIcious!</h1><h2>45 Milk St.</h2><h2>855-932-7871</h2><div class=\"split\"><h2>Guest Check</h2><h2>Individual Order</h2></div><div class=\"split\"><h2>Takeout</h2>\n<h2>Ticket " + "13" + "</h2>\n</div><div class=\"split\"><h2>Server : Sameem</h2><h2>Year Up United</h2></div><div class=\"split\">\n<h2>").append(timeString).append("</h2>\n<h2>DATE ").append(dateString).append("</h2>\n</div><h2>__________________________________________________</h2>");
        double totalPrice = 0;
        for (Orderable item : cart) {
            totalPrice += item.getPrice();
            // Adding item and item price to receipt body
            receipt.append("<div class=\"split\">\n<h2 style=\"white-space: pre-line\">").append(item).append("</h2>").append("<h2>").append(df.format(item.getPrice())).append("</h2></div>");
        }
        // Adding receipt footer to close the HTML
        receipt.append("<h2>----------------------------------------------------------------------------</h2><div class=\"split\"><h2></h2><h1>Check Total $ ").append(df.format(totalPrice)).append("</h1>\n</div><br><br><h2>Thanks for joining us at DELIcious.</h2><h2>Stay updated at...</h2><h2>yearup.org</h2><h2>NY Style Deli</h2></div></body></html>\n");
        writer.write(receipt.toString());
        writer.close();
    }
}
