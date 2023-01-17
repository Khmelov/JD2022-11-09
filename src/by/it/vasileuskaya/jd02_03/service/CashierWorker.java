package by.it.vasileuskaya.jd02_03.service;

import by.it.vasileuskaya.jd02_03.config.Dispatcher;
import by.it.vasileuskaya.jd02_03.model.Cashier;
import by.it.vasileuskaya.jd02_03.model.Customer;
import by.it.vasileuskaya.jd02_03.model.CustomerQueue;
import by.it.vasileuskaya.jd02_03.model.Store;
import by.it.vasileuskaya.jd02_03.util.RandomGenerator;
import by.it.vasileuskaya.jd02_03.util.Sleeper;

public class CashierWorker implements Runnable {

    public static final int MIN_TIMEOUT_SERVICE_CUSTOMER = 2000;
    public static final int MAX_TIMEOUT_SERVICE_CUSTOMER = 5000;
    private final Cashier cashier;
    private final Dispatcher dispatcher;
    private final CustomerQueue customerQueue;

    public CashierWorker(Cashier cashier, Store store) {
        this.cashier = cashier;
        dispatcher = store.getDispatcher();
        customerQueue = store.getCustomerQueue();
    }

    @Override
    public void run() {
        System.out.println(cashier + " opened");
        while (!dispatcher.storeIsClose()) {
            Customer customer = customerQueue.poll();
            if (customer != null) {
                synchronized (customer) {
                    System.out.println(cashier + " started service for " + customer);
                    int timeout = RandomGenerator.get(MIN_TIMEOUT_SERVICE_CUSTOMER, MAX_TIMEOUT_SERVICE_CUSTOMER);
                    Sleeper.sleep(timeout);
                    System.out.println(cashier + " finished service for " + customer);
                    customer.setWaiting(false);
                    customer.notify();
                }
            } else {
                Thread.onSpinWait();
            }
        }
        System.out.println(cashier + " closed");
    }
}
