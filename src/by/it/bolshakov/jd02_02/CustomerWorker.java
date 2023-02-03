package by.it.bolshakov.jd02_02;

import java.util.Random;

public class CustomerWorker extends Thread implements CustomerAction {

    public static final int MIN_TIMEOUT = 500;
    public static final int MAX_TIMEOUT = 2000;
    private final Customer customer;
    private final Store store;
    private final Dispatcher dispatcher;
    private final CustomerQueue customerQueue;
    
    public CustomerWorker(Store store, Customer customer) {
        this.store = store;
        this.customer = customer;
        dispatcher = store.getDispatcher();
        customerQueue = store.getCustomerQueue();
        dispatcher.addCustomer();
    }
    
    @Override
    public void run() {
        enteredStore();
        System.out.println(customer + " started to choose goods ");
        if (customer.hasCart()){
            for (int i = 0; i < new Random().nextInt(2, 5); i++) {
                chooseGood();
            }
        }
        else chooseGood();
        System.out.println(customer + " finished choose goods ");
        goToQueue();
        goOut();
        dispatcher.leaveCustomer();
    }

    @Override
    public void enteredStore() {
        System.out.println(customer + " entered to the " + store);
    }

    @Override
    public Good chooseGood() {
        Good good = PriceListRepo
                .priceList
                .keySet()
                .stream()
                .skip( new Random().nextInt(PriceListRepo.priceList.keySet().size()) )
                .findFirst()
                .orElse(null);
        if (customer.hasCart()) {
            customer.getCart().addToCart(good);
        }
        int timeout = RandomGenerator.get(MIN_TIMEOUT, MAX_TIMEOUT);
        Sleeper.sleep(timeout);
        return null;
    }

    @Override
    public void goToQueue() {
        synchronized (customer) {
            customerQueue.add(customer);
            customer.setWaiting(true);
            while (customer.isWaiting()) {
                try {
                    customer.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    public void goOut() {
        System.out.println(customer + " leaves the " + store);
    }
}
