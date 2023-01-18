package by.it.han.jd02_03.model;

import by.it.han.jd02_03.config.Manager;

public class Store {
    private final String name;
    private final Manager manager;
    private final CustomerQueue customerQueue;
    private final PriceListRepo priceListRepo;

    public Store(String name, Manager manager, CustomerQueue customerQueue) {
        this.name = name;
        this.manager = manager;
        this.customerQueue = customerQueue;
        this.priceListRepo = new PriceListRepo();
    }

    public String getName() {
        return name;
    }

    public Manager getManager() {
        return manager;
    }

    public CustomerQueue getCustomerQueue() {
        return customerQueue;
    }

    public PriceListRepo getPriceListRepo() {
        return priceListRepo;
    }

    @Override
    public String toString() {
        return name;
    }
}
