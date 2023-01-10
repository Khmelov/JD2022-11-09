package by.it.cherny.jd02_01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Store extends Thread{

    public static final int WORKING_TIME = 120;
    public static final int ONE_SECOND = 1000;
    public final String name;

    public Store(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        loadPriceList();
        System.out.println(name+ " opened");
        List<Thread> threads = new ArrayList<>();
        int indexCustomer=0; 
        for (int second = 0; second < WORKING_TIME; second++) {
            int countCustomerPerSecond = RandomGenerator.get(2);
            for (int n = 0; n < countCustomerPerSecond; n++) {
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
