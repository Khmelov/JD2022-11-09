package by.it._classwork_.jd02_03.entity;

import by.it._classwork_.jd02_03.config.Dispatcher;

public record Store(String name, Dispatcher dispatcher, CustomerQueue customerQueue) {

    @Override
    public String toString() {
        return name;
    }
}
