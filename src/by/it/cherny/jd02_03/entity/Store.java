package by.it.cherny.jd02_03.entity;

import by.it.cherny.jd02_03.config.Dispatcher;

public class Store{

    private final String name;
    private final Dispatcher dispatcher;
    private final CustomerQueue customerQueue;

    public Store(String name, Dispatcher dispatcher, CustomerQueue customerQueue) {
        this.name = name;
        this.dispatcher = dispatcher;
        this.customerQueue = customerQueue;
        new PriceListRepo();
    }

    public String getName() {
        return name;
    }

    public Dispatcher getDispatcher() {
        return dispatcher;
    }

    public CustomerQueue getCustomerQueue() {
        return customerQueue;
    }

    @Override
    public String toString() {
        return name;
    }
}
