package by.it.bolshakov.jd02_03.service;

import by.it.bolshakov.jd02_03.config.CustomerQueue;
import by.it.bolshakov.jd02_03.config.Dispatcher;
import by.it.bolshakov.jd02_03.util.RandomGenerator;
import by.it.bolshakov.jd02_03.util.Sleeper;
import by.it.bolshakov.jd02_03.entity.Customer;
import by.it.bolshakov.jd02_03.entity.Good;
import by.it.bolshakov.jd02_03.entity.Store;

public class CustomerWorker extends Thread implements CustomerAction {

    public static final int MIN_TIMEOUT = 500;
    public static final int MAX_TIMEOUT = 2000;
    private final Customer customer;
    private final Store store;
    private final Dispatcher dispatcher;
    private final CustomerQueue customerQueue;

    public CustomerWorker(Store store, Customer customer) {
        this.store = store;
        this.customer = customer;
        dispatcher = store.dispatcher();
        customerQueue = store.customerQueue();
        dispatcher.addCustomer();
    }

    @Override
    public void run() {
        enteredStore();
        chooseGood();
        goToQueue();
        goOut();
        dispatcher.leaveCustomer();
    }

    @Override
    public void enteredStore() {
        System.out.println(customer + " entered to the " + store);
    }

    @Override
    public Good chooseGood() {
        System.out.println(customer + " started to choose goods ");
        int timeout = RandomGenerator.get(MIN_TIMEOUT, MAX_TIMEOUT);
        Sleeper.sleep(timeout);
        System.out.println(customer + " finished choose goods ");
        return null;
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
        System.out.println(customer + " leaves the " + store);
    }
}
