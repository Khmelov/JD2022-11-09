package by.it.cherny.jd02_03;

import by.it.cherny.jd02_03.config.Dispatcher;
import by.it.cherny.jd02_03.entity.CartQueue;
import by.it.cherny.jd02_03.entity.CustomerQueue;
import by.it.cherny.jd02_03.entity.Store;
import by.it.cherny.jd02_03.service.StoreWorker;

public class Runner {
    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++) {
            Dispatcher dispatcher = new Dispatcher(200);
            CustomerQueue customerQueue = new CustomerQueue();
            CartQueue cartQueue = new CartQueue();
            Store store = new Store("Sosedi", dispatcher, customerQueue, cartQueue);
            new StoreWorker(store).start();
//        }
    }
}
