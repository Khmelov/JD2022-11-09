package by.it.bolshakov.jd02_03;

import by.it.bolshakov.jd02_03.config.CustomerQueue;
import by.it.bolshakov.jd02_03.config.Dispatcher;
import by.it.bolshakov.jd02_03.entity.Store;
import by.it.bolshakov.jd02_03.service.StoreWorker;

public class Runner {
    public static void main(String[] args) {
            Dispatcher dispatcher = new Dispatcher(100);
            CustomerQueue customerQueue = new CustomerQueue();
            Store store = new Store("Sosedi",dispatcher,customerQueue);
            new StoreWorker(store).start();
    }
}
