package by.it.yaroshevich.jd02_03;

import by.it.yaroshevich.jd02_03.config.Dispatcher;
import by.it.yaroshevich.jd02_03.entity.CustomerQueue;
import by.it.yaroshevich.jd02_03.entity.Store;
import by.it.yaroshevich.jd02_03.service.StoreWorker;
import lombok.Builder;

public class Runner {
    public static void main(String[] args) {
        Dispatcher dispatcher = new Dispatcher(100);
        CustomerQueue customerQueue = new CustomerQueue();
        Store store = new Store("Sosedi", dispatcher, customerQueue);
        new StoreWorker(store).start();
    }
}
