package by.it.han.jd02_03;

import by.it.han.jd02_03.config.Manager;
import by.it.han.jd02_03.model.CustomerQueue;
import by.it.han.jd02_03.model.Store;
import by.it.han.jd02_03.service.impl.StoreWorker;

public class Runner {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Manager manager = new Manager(100);
            CustomerQueue customerQueue = new CustomerQueue();
            Store store = new Store("FixPrice ", manager, customerQueue);
            new StoreWorker(store).start();
        }
    }
}
