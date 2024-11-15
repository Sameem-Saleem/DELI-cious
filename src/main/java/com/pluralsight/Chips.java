package com.pluralsight;

public class Chips implements Orderable {
    /**
     * The brand of chip.
     */
    private final Brand brand;

    public Chips(int brand) {
        switch (brand) {
            case 1 -> this.brand = Brand.TAKIS;
            case 2 -> this.brand = Brand.DORITOS;
            default -> this.brand = Brand.LAYS;
        }
    }

    public String getBrand() {
        return this.brand.name();
    }

    public double getPrice() {
        return 1.50;
    }

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
