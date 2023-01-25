package by.it.vasileuskaya.jd02_03.config;

import java.util.concurrent.atomic.AtomicLong;

public class Dispatcher {
    private final int MAX_CUSTOMER_COUNT;
    private final AtomicLong countIn = new AtomicLong();
    private final AtomicLong countOut = new AtomicLong();

    public Dispatcher(int max_customer_count) {
        MAX_CUSTOMER_COUNT = max_customer_count;
    }

    public void enteredCustomer() {
        countIn.incrementAndGet();
    }

    public void leftCustomer() {
        countOut.incrementAndGet();
    }

    public boolean storeIsOpen() {
        return countIn.get() != MAX_CUSTOMER_COUNT;
    }

    public boolean storeIsClose() {
        return countOut.get() == MAX_CUSTOMER_COUNT;
    }
}
