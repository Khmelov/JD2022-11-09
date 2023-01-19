package by.it.cherny.jd02_03.service;

import by.it.cherny.jd02_03.config.Dispatcher;
import by.it.cherny.jd02_03.util.RandomGenerator;
import by.it.cherny.jd02_03.util.Sleeper;
import by.it.cherny.jd02_03.entity.Cashier;
import by.it.cherny.jd02_03.entity.Customer;
import by.it.cherny.jd02_03.entity.Store;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class StoreWorker extends Thread{

    public static final int ONE_SECOND = 1000;
    public static final int N_THREADS = 2;

    private final Store store;
    private final String name;
    private final Dispatcher dispatcher;

    public StoreWorker(Store store) {
        this.store = store;
        name = store.getName();
        dispatcher = store.getDispatcher();
    }

    @Override
    public void run() {
        System.out.println(name+ " opened");
        // starts 2 cashiers
        ExecutorService cashierPool = Executors.newFixedThreadPool(StoreWorker.N_THREADS);

        for (int numberCashier = 1; numberCashier < 3; numberCashier++) {
            Cashier cashier = new Cashier(numberCashier);
            CashierWorker cashierWorker = new CashierWorker(cashier, store);
            cashierPool.execute(cashierWorker);
        }
        cashierPool.shutdown();

        int indexCustomer=0;
        while (dispatcher.storeIsOpened()) {
            int countCustomerPerSecond = RandomGenerator.get(2);
            for (int n = 0; n < countCustomerPerSecond&& dispatcher.storeIsOpened(); n++) {
                Customer customer = new Customer(++indexCustomer);
                CustomerWorker customerWorker = new CustomerWorker(store, customer);
                customerWorker.start();
            }
            Sleeper.sleep(StoreWorker.ONE_SECOND);
        }

        try {
            while(!cashierPool.awaitTermination(StoreWorker.ONE_SECOND, TimeUnit.MILLISECONDS)){
                System.out.println(name+" is worked");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(name+ " closed");
    }
}
