package by.it._classwork_.jd02_03.entity;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class CustomerQueue {

    public static final int MAX_CUSTOMER_COUNT = 30;
    public static final long TIMEOUT = 10L;

    private final BlockingDeque<Customer> customerDeque = new LinkedBlockingDeque<>(MAX_CUSTOMER_COUNT);

    public void add(Customer customer) {
        try {
            customerDeque.putLast(customer);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Customer poll() {
        try {
            return customerDeque.pollFirst(TIMEOUT, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
