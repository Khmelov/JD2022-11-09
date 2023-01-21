package by.it.samatokhin.jd02_03.entity;

import by.it.samatokhin.jd02_03.config.Dispatcher;

public record Store(String name, Dispatcher dispatcher,
                    CustomerQueue customerQueue) {

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
