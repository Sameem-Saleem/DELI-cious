package com.pluralsight;

public class Drink {
    private final String brand;
    private final String size;

    public Drink(String brand, String size) {
        this.brand = brand;
        this.size = size;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getSize() {
        return this.size;
    }
}
