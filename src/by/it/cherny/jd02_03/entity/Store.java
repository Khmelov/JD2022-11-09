package by.it.cherny.jd02_03.entity;

import by.it.cherny.jd02_03.config.Dispatcher;

public class Store{

    private final String name;
    private final Dispatcher dispatcher;
    private final CustomerQueue customerQueue;
    private final CartQueue cartQueue;

    public Store(String name, Dispatcher dispatcher, CustomerQueue customerQueue, CartQueue cartQueue) {
        this.name = name;
        this.dispatcher = dispatcher;
        this.customerQueue = customerQueue;
        this.cartQueue = cartQueue;
        new PriceListRepo();
    }

    public CartQueue getCartQueue() {
        return cartQueue;
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
