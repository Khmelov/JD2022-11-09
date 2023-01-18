package by.it.han.jd02_03.model;

import java.util.concurrent.atomic.AtomicLong;

import static by.it.han.jd02_03.util.StringsConstantUtils.CASHIER_NAME;

public class Cashier {
    private final String name;
    private final AtomicLong totalSum = new AtomicLong();

    public Cashier(int number) {
        this.name = CASHIER_NAME.formatted(number);
    }

    public long getTotalSum() {
        return totalSum.get();
    }

    public void addPriceGood(int price) {
        totalSum.getAndAdd(price);
    }

    @Override
    public String toString() {
        return name;
    }
}