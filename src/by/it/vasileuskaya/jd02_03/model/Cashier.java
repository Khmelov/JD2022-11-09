package by.it.vasileuskaya.jd02_03.model;

public class Cashier {
    private final String name;
    private double revenue;

    public Cashier(int number) {
        this.name = "\tCashier #" + number;
        this.revenue = revenue;
    }

    @Override
    public String toString() {
        return name;
    }
}
