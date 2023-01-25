package by.it.bolshakov.jd02_03.entity;

import by.it.bolshakov.jd02_03.config.Dispatcher;
import by.it.bolshakov.jd02_03.config.CustomerQueue;

public record Store(String name, Dispatcher dispatcher, CustomerQueue customerQueue) {

    @Override
    public String toString() {
        return name;
    }
}
