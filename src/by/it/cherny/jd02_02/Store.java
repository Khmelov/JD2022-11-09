package by.it.cherny.jd02_02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Store extends Thread{

    public static final int WORKING_TIME = 120;
    public static final int ONE_SECOND = 1000;
    public final String name;
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
        loadPriceList();
        System.out.println(name+ " opened");
        List<Thread> threads = new ArrayList<>();
            // starts 2 cashiers
        for (int numberCashier = 1; numberCashier < 3; numberCashier++) {
            Cashier cashier = new Cashier(numberCashier);
            CashierWorker cashierWorker = new CashierWorker(cashier, this);
            Thread thread = new Thread(cashierWorker);
            threads.add(thread);
            thread.start();
        }

        int indexCustomer=0; 
        while (getDispatcher().storeIsOpened()) {
            int countCustomerPerSecond = RandomGenerator.get(2);
            for (int n = 0; n < countCustomerPerSecond&& dispatcher.storeIsOpened(); n++) {
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
        System.out.println(name+ " closed");
    }

    private void loadPriceList() {
        Map<String, Double> list = new HashMap<>();
        list.put("ice-cream", 2.0);
        list.put("sausages", 4.5);
        list.put("bread", 1.3);
        list.put("meat", 9.99);
        list.put("eggs", 2.01);
        list.put("sauce", 1.5);
        list.put("sushi", 10.2);
        list.put("pizza", 15.0);
        PriceListRepo.setList(list);
    }

    @Override
    public String toString() {
        return name;
    }
}
