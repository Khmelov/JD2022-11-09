package by.it.han.jd02_03.service.impl;

import by.it.han.jd02_03.config.Manager;
import by.it.han.jd02_03.model.Cashier;
import by.it.han.jd02_03.model.Customer;
import by.it.han.jd02_03.model.CustomerQueue;
import by.it.han.jd02_03.model.Store;
import by.it.han.jd02_03.service.PrintCheque;
import by.it.han.jd02_03.util.RandomUtils;
import by.it.han.jd02_03.util.SleeperUtils;

import java.util.Map;

import static by.it.han.jd02_03.util.StringsConstantUtils.*;

public class CashierWorker implements Runnable {
    public static final int MIN_TIMEOUT_SERVICE_CUSTOMER = 2;
    public static final int MAX_TIMEOUT_SERVICE_CUSTOMER = 5;
    private final Cashier cashier;
    private final Manager manager;
    private final CustomerQueue customerQueue;

    public CashierWorker(Cashier cashier, Store store) {
        this.cashier = cashier;
        manager = store.getManager();
        customerQueue = store.getCustomerQueue();
    }

    @Override
    public void run() {
        System.out.printf(OPENED, cashier);
        while (!manager.storeIsClosed()) {
            Customer customer = customerQueue.poll();
            if (customer != null) {
                Map<String, Integer> customerGoods = customer.getGoods();
                synchronized (customer.getMonitor()) {
                    System.out.printf(STARTED_SERVICE, cashier, customer);
                    int timeOut = RandomUtils.get(MIN_TIMEOUT_SERVICE_CUSTOMER, MAX_TIMEOUT_SERVICE_CUSTOMER);
                    for (Map.Entry<String, Integer> good : customerGoods.entrySet()) {
                        cashier.addPriceGood(good.getValue());
                    }
                    SleeperUtils.getSleep(timeOut);
                    PrintCheque printCheque = new PrintCheque(customerGoods, customer);
                    System.out.printf(FINISHED_SERVICE, cashier, customer);
                    printCheque.run();
                    customer.setWaiting(false);
                    customer.notify();
                }
            } else {
                Thread.onSpinWait();
            }
        }
        System.out.printf(TOTAL_SUM, cashier, cashier.getTotalSum());
    }
}
