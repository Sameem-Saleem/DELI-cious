package com.pluralsight;

public class Chips implements Orderable {
    /**
     * The brand of chip.
     */
    private Brand brand;

    /**
     * Constructs {@code Chips} given an integer that represent the brand.
     *
     * @param brand Represents the brand of chips, 1 = Takis, 2 = Doritos, 3 = Lays.
     */
    public Chips(int brand) {
        switch (brand) {
            case 1 -> this.brand = Brand.TAKIS;
            case 2 -> this.brand = Brand.DORITOS;
            case 3 -> this.brand = Brand.LAYS;
        }
    }

    /**
     * Returns a double representing the cost of the drink.
     *
     * @return Returns the static cost of chips, 1.50.
     */
    public double getPrice() {
        return 1.50;
    }


    /**
     * Returns a {@code String} representation of the chips.
     *
     * @return Returns the name of the brand, such as: "Doritos".
     */
    @Override
    public String toString() {
        return this.brand.name();
    }

    enum Brand {
        TAKIS, DORITOS, LAYS;

        @Override
        public String toString() {
            return this.name();
        }
    }
}
