package by.it._classwork_.jd02_03;

import by.it._classwork_.jd02_03.config.Dispatcher;
import by.it._classwork_.jd02_03.entity.CustomerQueue;
import by.it._classwork_.jd02_03.entity.Store;
import by.it._classwork_.jd02_03.service.StoreWorker;

public class Runner {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            Dispatcher dispatcher = new Dispatcher(100);
            CustomerQueue customerQueue = new CustomerQueue();
            Store store = new Store("Sosedi"+i,dispatcher,customerQueue);
            new StoreWorker(store).start();
        }

    }
}
