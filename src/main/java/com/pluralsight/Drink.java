package com.pluralsight;

public class Drink implements Orderable {
    private final Brand brand;
    private final Size size;

    public Drink(int brand, int size) {
        switch (brand) {
            case 1 -> this.brand = Brand.COCA_COLA;
            case 2 -> this.brand = Brand.MOUNTAIN_DEW;
            case 3 -> this.brand = Brand.PEPSI;
            default -> this.brand = Brand.FANTA;
        }
        switch (size) {
            case 1 -> this.size = Size.SMALL;
            case 2 -> this.size = Size.MEDIUM;
            default -> this.size = Size.LARGE;
        }
    }

    public double getPrice() {
        return this.size.getPrice();
    }

    @Override
    public String toString() {
        return this.size + " " + this.brand;
    }

    enum Size {
        SMALL(2.00, "Small"), MEDIUM(2.50, "Medium"), LARGE(3.00, "Large");
        private final double price;
        private final String displayName;

        Size(double price, String displayName) {
            this.price = price;
            this.displayName = displayName;
        }

        public double getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return this.displayName;
        }
    }

    enum Brand {
        COCA_COLA("Coca Cola"), MOUNTAIN_DEW("Mountain Dew"), PEPSI("Pepsi"), FANTA("Fanta");
        private final String displayName;

        Brand(String displayName) {
            this.displayName = displayName;
        }

        @Override
        public String toString() {
            return this.displayName;
        }
    }
}
