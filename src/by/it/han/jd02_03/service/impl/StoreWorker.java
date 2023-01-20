package by.it.han.jd02_03.service.impl;

import by.it.han.jd02_03.model.Cashier;
import by.it.han.jd02_03.model.Customer;
import by.it.han.jd02_03.model.PriceListRepo;
import by.it.han.jd02_03.model.Store;
import by.it.han.jd02_03.util.RandomUtils;
import by.it.han.jd02_03.util.SleeperUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static by.it.han.jd02_03.util.StringsConstantUtils.*;

public class StoreWorker extends Thread {
    private static final int CASHIER_COUNT = 2;
    private static final double SLEEP_BETWEEN_BYERS = 1;
    private static final long TIMEOUT = 10L;
    private static final int CUSTOMER_COUNT = 2;
    private final Store store;

    public StoreWorker(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        System.out.println(store.getName() + OPENED);
        int indexCustomer = 0;
        ExecutorService cashierPool = Executors.newFixedThreadPool(CASHIER_COUNT);

        for (int cashierNumber = 1; cashierNumber <= CASHIER_COUNT; cashierNumber++) {
            Cashier cashier = new Cashier(cashierNumber);
            CashierWorker cashierWorker = new CashierWorker(cashier, store);
            cashierPool.execute(cashierWorker);
        }

        cashierPool.shutdown();

        while (store.getManager().storeIsOpened()) {
            int countCustomer = RandomUtils.get(CUSTOMER_COUNT);
            for (int j = 0; j < countCustomer && store.getManager().storeIsOpened(); j++) {
                Customer customer = new Customer(++indexCustomer, new PriceListRepo());
                CustomerWorker worker = new CustomerWorker(store, customer);
                SleeperUtils.getSleep(SLEEP_BETWEEN_BYERS);
                worker.start();
            }
            SleeperUtils.getSleep(SLEEP_BETWEEN_BYERS);
        }

        try {
            while (!cashierPool.awaitTermination(TIMEOUT, TimeUnit.MILLISECONDS)) {
                System.out.printf(WORKED, store.getName());
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf(CLOSED, store.getName());
    }
}
