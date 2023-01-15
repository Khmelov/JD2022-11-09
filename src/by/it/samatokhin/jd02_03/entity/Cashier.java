package by.it.samatokhin.jd02_03.entity;

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
