package by.it._classwork_.jd02_02;

import java.util.ArrayDeque;
import java.util.Deque;

public class CustomerQueue {

    private final Deque<Customer> customerDeque = new ArrayDeque<>();
    private final Object innerMonitor = new Object();

    public void add(Customer customer) {
        synchronized (innerMonitor) {
            customerDeque.addLast(customer);
        }
    }

    public synchronized Customer poll() {
        synchronized (innerMonitor) {
            return customerDeque.pollFirst();
        }
    }
}
