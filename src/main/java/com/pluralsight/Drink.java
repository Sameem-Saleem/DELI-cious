package com.pluralsight;

public class Drink implements Orderable {
    /**
     * The brand of the drink to distinguish.
     */
    private Brand brand;
    /**
     * The size of drink, which directly affects getPrice().
     */
    private Size size;

    /**
     * Constructs a {@code Drink} given integers that represent attribute states.
     *
     * @param brand Represents the brand of drink, 1 = Coca Cola, 2 = Mountain Dew, 3 = Pepsi, 4 = Fanta.
     * @param size  Represents the size of drink, affecting price, 1 = Small, 2 = Medium, 3 = Large.
     */
    public Drink(int brand, int size) {
        switch (brand) {
            case 1 -> this.brand = Brand.COCA_COLA;
            case 2 -> this.brand = Brand.MOUNTAIN_DEW;
            case 3 -> this.brand = Brand.PEPSI;
            case 4 -> this.brand = Brand.FANTA;
        }
        switch (size) {
            case 1 -> this.size = Size.SMALL;
            case 2 -> this.size = Size.MEDIUM;
            case 3 -> this.size = Size.LARGE;
        }
    }

    /**
     * Returns a double representing the cost of the drink, attained from price.
     *
     * @return Returns the associated cost with the specific drink size.
     */
    public double getPrice() {
        return this.size.getPrice();
    }

    /**
     * Returns a {@code String} representation of the drink.
     *
     * @return Returns the size followed by the brand, such as: "Large Coca Cola".
     */
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
