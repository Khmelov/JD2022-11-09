package by.it.han.jd02_03.service.impl;

import by.it.han.jd02_03.config.Manager;
import by.it.han.jd02_03.model.Cashier;
import by.it.han.jd02_03.model.Customer;
import by.it.han.jd02_03.model.CustomerQueue;
import by.it.han.jd02_03.model.Store;
import by.it.han.jd02_03.util.RandomUtils;
import by.it.han.jd02_03.util.SleeperUtils;

import static by.it.han.jd02_03.util.StringsConstantUtils.*;

public class CashierWorker implements Runnable {
    public static final int MIN_TIMEOUT_SERVICE_CUSTOMER = 2;
    public static final int MAX_TIMEOUT_SERVICE_CUSTOMER = 5;
    private final Cashier cashier;
    private final Manager manager;
    private final CustomerQueue customerQueue;

    public CashierWorker(Cashier cashier, Store store) {
        this.cashier = cashier;
        manager = store.manager();
        customerQueue = store.customerQueue();
    }

    @Override
    public void run() {
        System.out.printf(OPENED, cashier);
        while (!manager.storeIsClosed()) {
            Customer customer = customerQueue.poll();
            if (customer != null) {
                synchronized (customer.getMonitor()) {
                    System.out.printf(STARTED_SERVICE, cashier, customer);
                    int timeOut = RandomUtils.get(MIN_TIMEOUT_SERVICE_CUSTOMER, MAX_TIMEOUT_SERVICE_CUSTOMER);
                    SleeperUtils.getSleep(timeOut);
                    System.out.printf(FINISHED_SERVICE, cashier, customer);
                    customer.setWaiting(false);
                    customer.notify();
                }
            } else {
                Thread.onSpinWait();
            }
        }
        System.out.printf(CLOSED, cashier);
    }
}
