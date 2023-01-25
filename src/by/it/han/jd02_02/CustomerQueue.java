package by.it.han.jd02_02;

import java.util.ArrayDeque;
import java.util.Deque;

public class CustomerQueue {
    private final Deque<Customer> customers = new ArrayDeque<>();

    public synchronized void add(Customer customer) {
        customers.addLast(customer);
    }

    public synchronized Customer poll() {
        return customers.pollFirst();
    }
}
