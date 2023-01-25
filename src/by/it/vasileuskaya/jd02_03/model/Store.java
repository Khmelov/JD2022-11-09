package by.it.vasileuskaya.jd02_03.model;

import by.it.vasileuskaya.jd02_03.config.Dispatcher;

public class Store {

    private final String name;
    private final Dispatcher dispatcher;
    private final CustomerQueue customerQueue;

    public String getName() {
        return name;
    }

    public Dispatcher getDispatcher() {
        return dispatcher;
    }

    public CustomerQueue getCustomerQueue() {
        return customerQueue;
    }

    public Store(String name, Dispatcher dispatcher, CustomerQueue customerQueue) {
        this.name = name;
        this.dispatcher = dispatcher;
        this.customerQueue = customerQueue;
    }

    @Override
    public String toString() {
        return name;
    }
}
