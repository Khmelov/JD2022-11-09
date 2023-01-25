package by.it.cherny.jd02_03;

import by.it.cherny.jd02_03.config.Dispatcher;
import by.it.cherny.jd02_03.entity.CustomerQueue;
import by.it.cherny.jd02_03.entity.Store;
import by.it.cherny.jd02_03.service.StoreWorker;

public class Runner {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Dispatcher dispatcher = new Dispatcher(100);
            CustomerQueue customerQueue = new CustomerQueue();
            Store store = new Store("Sosedi"+i, dispatcher, customerQueue);
            new StoreWorker(store).start();
        }
    }
}
