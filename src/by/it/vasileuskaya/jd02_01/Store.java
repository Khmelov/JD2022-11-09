package by.it.vasileuskaya.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Store extends Thread {

    public static final int FINISH_TIME = 120;
    public static final int ONE_SECOND = 1000;
    public final String name;

    public Store(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void run() {
        System.out.println(name + " opened");
        List<Thread> threads = new ArrayList<>();
        int indexCustomer = 0;
        for (int second = 0; second < FINISH_TIME; second++) {
            int countCustomerPerSecond = RandomGenerator.get(2);
            for (int n = 0; n < countCustomerPerSecond; n++) {
                Customer customer = new Customer(++indexCustomer);
                CustomerWorker customerWorker = new CustomerWorker(this, customer);
                threads.add(customerWorker);
                customerWorker.start();
            }
            Sleeper.sleep(ONE_SECOND);
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
        System.out.println(name + " closed");
    }
}
