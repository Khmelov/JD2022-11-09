package by.it.yaroshevich.jd02_03.entity;

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
