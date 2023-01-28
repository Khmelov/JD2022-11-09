package by.it.han.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Store extends Thread {
    public static final int WORK_TIME = 120;
    public static final String _OPENED_STRING = " opened";
    public static final String _CLOSE_STRING = " close";
    private final String name;
    private static final double SLEEP_BETWEEN_BYERS = 1;

    public Store(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(this + _OPENED_STRING);
        List<Thread> workers = new ArrayList<>();
        int countBuyers = 1;
        for (int i = 0; i < WORK_TIME; i++) {
            int countCustomer = RandomUtils.get(2);
            for (int indexCustomer = 0; indexCustomer < countCustomer; ) {
                Customer customer;
                if (countBuyers % 4 == 0 && countBuyers != 0) {
                    customer = new Pensioner("Pensioner №", ++indexCustomer, new PriceListRepo());
                    countBuyers++;
                } else if (countBuyers % 2 == 0 && countBuyers != 0) {
                    customer = new Student("Student №", ++indexCustomer, new PriceListRepo());
                    countBuyers++;
                } else {
                    customer = new Customer("Customer №", ++indexCustomer, new PriceListRepo());
                    countBuyers++;
                }
                CustomerWorker worker = new CustomerWorker(this, customer);
                SleeperUtils.getSleep(SLEEP_BETWEEN_BYERS);
                workers.add(worker);
                worker.start();
            }
            SleeperUtils.getSleep(SLEEP_BETWEEN_BYERS);
        }
        addToThreadList(workers);
        System.out.println(this + _CLOSE_STRING);
    }

    private static void addToThreadList(List<Thread> workers) {
        for (Thread worker : workers) {
            try {
                worker.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
