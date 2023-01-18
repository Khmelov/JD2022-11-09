package by.it.han.jd02_03.service.impl;

import by.it.han.jd02_03.config.Manager;
import by.it.han.jd02_03.model.*;
import by.it.han.jd02_03.service.CustomerAction;
import by.it.han.jd02_03.util.RandomUtils;
import by.it.han.jd02_03.util.SleeperUtils;

import static by.it.han.jd02_03.util.StringsConstantUtils.*;

public class CustomerWorker extends Thread implements CustomerAction {
    private final Store store;
    private final Customer customer;
    private final ShoppingCardWorker shoppingCardWorker;
    public static final double MIN_TIME = 0.5;
    public static final int MAX_TIME = 2;
    public static final int MIN_GOOD_COUNT = 2;
    public static final int MAX_GOOD_COUNT = 5;
    private final Manager manager;
    private final CustomerQueue customerQueue;

    public CustomerWorker(Store store, Customer customer) {
        this.store = store;
        this.customer = customer;
        shoppingCardWorker = new ShoppingCardWorker(new ShoppingCard(store, customer));
        manager = store.manager();
        customerQueue = store.customerQueue();
        manager.addCustomer();
    }

    @Override
    public void run() {
        enteredStore();
        shoppingCardWorker.takeCart();
        chooseGood();
        int count = RandomUtils.get(MIN_GOOD_COUNT, MAX_GOOD_COUNT);
        int num = 0;
        for (int i = 0; i < count; i++) {
            shoppingCardWorker.putToCart(new Good(), ++num);
        }
        goToQueue();
        goOut();
        manager.leaveCustomer();
    }

    @Override
    public void enteredStore() {
        System.out.printf(ENTERED_TO, customer, store);
    }

    @Override
    public Good chooseGood() {
        SleeperUtils.getSleep(MIN_TIME, MAX_TIME);
        System.out.printf(CHOSE_GOOD, customer, store);
        return new Good();
    }

    @Override
    public void goToQueue() {
        synchronized (customer) {
            customerQueue.add(customer);
            customer.setWaiting(true);
            while (customer.isWaiting()) {
                try {
                    customer.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    public void goOut() {
        System.out.printf(LEFT_FROM_STORE_WITH_GOOD_COUNT, customer, store, customer.getCountGoods());
    }

}
