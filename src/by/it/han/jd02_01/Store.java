package by.it.han.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Store extends Thread {
    public static final int WORK_TIME = 5;
    public static final String _OPENED_STRING = " opened";
    public static final String _CLOSE_STRING = " close";
    private final String name;
    private static final int ONE_SEC = 1;

    public Store(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(this + _OPENED_STRING);
        int indexCustomer = 0;
        List<Thread> workers = new ArrayList<>();
        for (int i = 0; i < WORK_TIME; i++) {
            int countCustomer = RandomUtils.get(2);
            for (int j = 0; j < countCustomer; j++) {
                CustomerWorker worker = new CustomerWorker(this, new Customer(++indexCustomer));
                worker.start();
                workers.add(worker);
            }
            SleeperUtils.getSleep(ONE_SEC);
        }
        for (Thread worker : workers) {
            try {
                worker.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(this + _CLOSE_STRING);
    }

    @Override
    public String toString() {
        return name;
    }
}
