package by.it.vasileuskaya.jd02_03.model;

public class Cashier {
    private final String name;

    public Cashier(int number) {
        this.name = "\tCashier #" + number;
    }

    @Override
    public String toString() {
        return name;
    }
}
