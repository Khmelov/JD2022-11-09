package by.it.vasileuskaya.jd02_03;

import by.it.vasileuskaya.jd02_03.config.Dispatcher;
import by.it.vasileuskaya.jd02_03.model.CustomerQueue;
import by.it.vasileuskaya.jd02_03.model.Store;
import by.it.vasileuskaya.jd02_03.service.StoreWorker;

public class Runner {
    public static void main(String[] args) {
        Dispatcher dispatcher = new Dispatcher(100);
        CustomerQueue customerQueue = new CustomerQueue();
        Store store = new Store("Biedronka", dispatcher, customerQueue);
        new StoreWorker(store).start();
    }
}
