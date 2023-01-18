package by.it.han.jd02_03.model;

import by.it.han.jd02_03.config.Manager;

public record Store(String name, Manager manager, CustomerQueue customerQueue) {

    @Override
    public String toString() {
        return name;
    }
}
