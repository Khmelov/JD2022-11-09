package by.it.vasileuskaya.jd02_02;

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
