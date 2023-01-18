package by.it.yaroshevich.jd02_03.service;

import by.it.yaroshevich.jd02_03.entity.CustomerQueue;
import by.it.yaroshevich.jd02_03.config.Dispatcher;
import by.it.yaroshevich.jd02_03.util.RandomGenerator;
import by.it.yaroshevich.jd02_03.util.Sleeper;
import by.it.yaroshevich.jd02_03.entity.Customer;
import by.it.yaroshevich.jd02_03.entity.Good;
import by.it.yaroshevich.jd02_03.entity.Store;

public class CustomerWorker extends Thread implements CustomerAction {
    public static final int MAX_TIMEOUT = 2000;
    public static final int MIN_TIMEOUT = 500;
    private final Store store;
    private final Customer customer;
    private final CustomerQueue customerQueue;

    private final Dispatcher dispatcher;

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
        System.out.println(customer + "entered to the " + store);
    }

    @Override
    public Good chooseGood() {
        System.out.println(customer + "started to choose goods");
        int timeout = RandomGenerator.get(MIN_TIMEOUT, MAX_TIMEOUT);
        Sleeper.sleep(timeout);
        System.out.println(customer + "finished to choose goods");
        return null;
    }

    @Override
    public void goToQueue() {
        synchronized (customer){
            customerQueue.add(customer);
            customer.setWaiting(true);
            while (customer.isWaiting()){
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
