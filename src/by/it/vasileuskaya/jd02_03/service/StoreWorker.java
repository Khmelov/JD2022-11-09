package by.it.vasileuskaya.jd02_03.service;

import by.it.vasileuskaya.jd02_03.config.Dispatcher;
import by.it.vasileuskaya.jd02_03.model.Cashier;
import by.it.vasileuskaya.jd02_03.model.Customer;
import by.it.vasileuskaya.jd02_03.model.Store;
import by.it.vasileuskaya.jd02_03.util.RandomGenerator;
import by.it.vasileuskaya.jd02_03.util.Sleeper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class StoreWorker extends Thread {
    private static final int ONE_SECOND = 1000;
    public static final int CUSTOMER_COUNT_THREADS = 2;
    private final Store store;
    private final String name;
    private final Dispatcher dispatcher;

    public StoreWorker(Store store) {
        this.store = store;
        name = store.getName();
        dispatcher = store.getDispatcher();
    }

    @Override
    public void run() {
        System.out.println(name + " opened");
        ExecutorService cashierPool = Executors.newFixedThreadPool(CUSTOMER_COUNT_THREADS);
        for (int numberCashier = 1; numberCashier <= CUSTOMER_COUNT_THREADS; numberCashier++) {
            Cashier cashier = new Cashier(numberCashier);
            CashierWorker cashierWorker = new CashierWorker(cashier, store);
            cashierPool.execute(cashierWorker);
        }
        cashierPool.shutdown();
        int indexCustomer = 0;
        while (dispatcher.storeIsOpen()) {
            int countCustomerPerSecond = RandomGenerator.get(CUSTOMER_COUNT_THREADS);
            for (int n = 0; n < countCustomerPerSecond && dispatcher.storeIsOpen(); n++) {
                Customer customer = new Customer(++indexCustomer);
                CustomerWorker customerWorker = new CustomerWorker(store, customer);
                customerWorker.start();
            }
            Sleeper.sleep(ONE_SECOND);
        }
        try {
            while (!cashierPool.awaitTermination(ONE_SECOND, TimeUnit.MILLISECONDS)) {
                System.out.println(name + " is worked");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(name + " closed");
    }
}
