package by.it.han.jd02_02;

public class CashierWorker implements Runnable {
    public static final int MIN_TIMEOUT_SERVICE_CUSTOMER = 2;
    public static final int MAX_TIMEOUT_SERVICE_CUSTOMER = 5;
    private final Cashier cashier;
    private final Store store;
    private final Manager manager;
    private final CustomerQueue customerQueue;

    public CashierWorker(Cashier cashier, Store store) {
        this.cashier = cashier;
        this.store = store;
        manager = store.getManager();
        customerQueue = store.getCustomerQueue();
    }

    @Override
    public void run() {
        System.out.println(cashier + " opened");
        while (!manager.storeIsClosed()) {
            Customer customer = customerQueue.poll();
            if (customer != null) {
                synchronized (customer) {
                    System.out.println(cashier + " started service for " + customer);
                    int timeOut = RandomUtils.get(MIN_TIMEOUT_SERVICE_CUSTOMER, MAX_TIMEOUT_SERVICE_CUSTOMER);
                    SleeperUtils.getSleep(timeOut);
                    System.out.println(cashier + " finished service for " + customer);
                    customer.setWaiting(false);
                    customer.notify();
                }
            }
            else {
                Thread.onSpinWait();
            }
        }
        System.out.println(cashier + " closed");
    }
}
