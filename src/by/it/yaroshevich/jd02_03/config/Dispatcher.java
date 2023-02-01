package by.it.yaroshevich.jd02_03.config;

import java.util.concurrent.atomic.AtomicLong;

public class Dispatcher {

    public final int MAX_CUSTOMER_COUNT;

    private final AtomicLong countIn = new AtomicLong();

    private final AtomicLong countOut = new AtomicLong();

    public Dispatcher(int max_customer_count) {
        MAX_CUSTOMER_COUNT = max_customer_count;
    }

    public void addCustomer(){
        countIn.incrementAndGet();
    }

    public void leftCustomer(){
        countOut.incrementAndGet();
    }

    public boolean storeIsOpened(){
        return countIn.get() != MAX_CUSTOMER_COUNT;
    }

    public boolean storeIsClosed(){
        return countOut.get() == MAX_CUSTOMER_COUNT;
    }
}
