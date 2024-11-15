package com.pluralsight;

public class Chips implements Orderable {
    private String brand;

    public Chips(int brand) {
        switch (brand) {
            case 1 -> this.brand = "Takis";
            case 2 -> this.brand = "Doritos";
            case 3 -> this.brand = "Lays";
        }
    }

    public String getBrand() {
        return this.brand;
    }

    public double getPrice() {
        return 1.50;
    }
}
