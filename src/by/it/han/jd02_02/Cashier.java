package by.it.han.jd02_02;

public class Cashier {
    private final String name;
    private volatile long totalSum = 0;

    public Cashier(int number) {
        this.name = "\tCashier #" + number;
    }

    public synchronized void addPriceGood(int price) {
        totalSum += price;
    }

    public long getTotalSum() {
        return totalSum;
    }

    @Override
    public String toString() {
        return name;
    }
}