package by.it.han.jd02_03.model;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class CustomerQueue {
    public static final int MAX_CUSTOMER_QUEUE_COUNT = 30;
    public static final long TIMEOUT = 10L;
    private final BlockingDeque<Customer> customers = new LinkedBlockingDeque<>(MAX_CUSTOMER_QUEUE_COUNT);

    public void add(Customer customer) {
        try {
            customers.put(customer);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Customer poll() {
        try {
            return customers.pollFirst(TIMEOUT, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
