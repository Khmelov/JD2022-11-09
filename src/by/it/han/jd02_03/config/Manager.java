package by.it.han.jd02_03.config;

import java.util.concurrent.atomic.AtomicInteger;

public class Manager {
    private final int MAX_CUSTOMER_COUNT;
    private final AtomicInteger customerCountIn = new AtomicInteger();
    private final AtomicInteger customerCountOut = new AtomicInteger();

    public Manager(int max_customer_count) {
        MAX_CUSTOMER_COUNT = max_customer_count;
    }

    public void addCustomer() {
        customerCountIn.incrementAndGet();
    }

    public void leaveCustomer() {
        customerCountOut.incrementAndGet();
    }

    public boolean storeIsOpened() {
        return customerCountIn.get() != MAX_CUSTOMER_COUNT;
    }

    public boolean storeIsClosed() {
        return customerCountOut.get() == MAX_CUSTOMER_COUNT;
    }
}
