package by.it.han.jd02_02;

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