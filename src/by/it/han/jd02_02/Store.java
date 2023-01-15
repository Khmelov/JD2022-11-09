package by.it.han.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Store extends Thread {
    public static final String _OPENED_STRING = " opened";
    public static final String _CLOSE_STRING = " close";
    private final String name;
    private final Manager manager;
    private final CustomerQueue customerQueue;
    private static final double SLEEP_BETWEEN_BYERS = 1;

    public Store(String name, Manager manager, CustomerQueue customerQueue) {
        this.name = name;
        this.manager = manager;
        this.customerQueue = customerQueue;
    }

    public Manager getManager() {
        return manager;
    }

    public CustomerQueue getCustomerQueue() {
        return customerQueue;
    }

    @Override
    public void run() {
        System.out.println(this + _OPENED_STRING);
        int indexCustomer = 0;
        List<Thread> workers = new ArrayList<>();

        for (int cashierNumber = 1; cashierNumber < 3; cashierNumber++) {
            Cashier cashier = new Cashier(cashierNumber);
            CashierWorker cashierWorker = new CashierWorker(cashier, this);
            Thread thread = new Thread(cashierWorker);
            workers.add(thread);
            thread.start();
        }
        while (manager.storeIsOpened()) {
            int countCustomer = RandomUtils.get(2);
            for (int j = 0; j < countCustomer && manager.storeIsOpened(); j++) {
                Customer customer = new Customer(++indexCustomer, new PriceListRepo());
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
