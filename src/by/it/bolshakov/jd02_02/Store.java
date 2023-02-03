package by.it.bolshakov.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Store extends Thread{

    private static final int FINISH_TIME = 120;
    private static final int ONE_SECOND = 1000;
    private final String name;
    private final Dispatcher dispatcher;
    private final CustomerQueue customerQueue;

    public Dispatcher getDispatcher() {
        return dispatcher;
    }

    public CustomerQueue getCustomerQueue() {
        return customerQueue;
    }

    public Store(String name, Dispatcher dispatcher, CustomerQueue customerQueue) {
        this.name = name;
        this.dispatcher = dispatcher;
        this.customerQueue = customerQueue;
    }

    @Override
    public void run() {
        System.out.println(name+" opened");
        List<Thread> threads=new ArrayList<>();

        for (int numberCashier = 1; numberCashier <= 2; numberCashier++) {
            Cashier cashier = new Cashier(numberCashier);
            CashierWorker cashierWorker = new CashierWorker(cashier, this);
            Thread thread = new Thread(cashierWorker);
            threads.add(thread);
            thread.start();
        }

        int indexCustomer = 0;
        while (dispatcher.storeIsOpened()) {
            int countCustomerPerSecond = RandomGenerator.get(2);
            for (int n = 0; n < countCustomerPerSecond && dispatcher.storeIsOpened(); n++) {
                Customer customer = new Customer(++indexCustomer);
                CustomerWorker customerWorker = new CustomerWorker(this, customer);
                threads.add(customerWorker);
                customerWorker.start();
            }
            Sleeper.sleep(ONE_SECOND);
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(name+" closed");
    }

    @Override
    public String toString() {
        return name;
    }
}
