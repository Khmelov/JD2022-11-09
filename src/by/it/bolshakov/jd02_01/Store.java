package by.it.bolshakov.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Store extends Thread {
    private static final int FINISH_TIME = 120;
    private static final int ONE_SEC = 1000;

    public final String name;

    public Store(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + " opened");
        List<Thread> threads = new ArrayList<>();
        int customerIndex = 0;
        for (int second = 0; second < FINISH_TIME; second++) {
            int customerPerSecond = RandomGenerator.get(2);
            for (int i = 0; i < customerPerSecond; i++) {
                Customer customer = new Customer(++customerIndex);
                CustomerWorker customerWorker = new CustomerWorker(this, customer);
                threads.add(customerWorker);
                customerWorker.start();
            }
            Sleeper.sleep(ONE_SEC);
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

    @Override
    public String toString() {
        return this.name;
    }
}
