package com.pluralsight;

public class Drink implements Orderable {
    private final Brand brand;
    private final Size size;

    public Drink(String brand, String size) {
        this.brand = Brand.valueOf(brand);
        this.size = Size.valueOf(size);
    }

    public String getBrand() {
        return this.brand.displayName;
    }

    public Size getSize() {
        return this.size;
    }

    public double getPrice() {
        return this.size.getPrice();
    }

    @Override
    public String toString() {
        return this.size + " " + this.size;
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
