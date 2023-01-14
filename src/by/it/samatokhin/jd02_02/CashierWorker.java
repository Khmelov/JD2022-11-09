package by.it.samatokhin.jd02_02;

public class CashierWorker implements Runnable {

    public static final int MIN_TIMEOUT_SERVICE_CUSTOMER = 2000;
    public static final int MAX_TIMEOUT_SERVICE_CUSTOMER = 5000;
    private final Cashier cashier;
    private final Store store;
    private final Dispatcher dispatcher;
    private final CustomerQueue customerQueue;


    public CashierWorker(Cashier cashier, Store store) {
        this.cashier = cashier;
        this.store = store;
        dispatcher = store.getDispatcher();
        customerQueue = store.getCustomerQueue();
    }


    @Override
    public void run() {
        System.out.println(cashier + " opened");
        while (!dispatcher.storeIsClosed()) {
            Customer customer = customerQueue.poll();
            if (customer != null) {
                synchronized (customer) {
                    System.out.println(cashier + " started service for " + customer);
                    int timeout = RandomGenerator.get(
                            MIN_TIMEOUT_SERVICE_CUSTOMER,
                            MAX_TIMEOUT_SERVICE_CUSTOMER
                    );
                    Sleeper.sleep(timeout);
                    System.out.println(cashier + " finished service for " + customer);
                    customer.setWaiting(false);
                    customer.notify();
                }
            } else {
                Sleeper.sleep(100);
            }
        }
        System.out.println(cashier + " closed");
    }
}
