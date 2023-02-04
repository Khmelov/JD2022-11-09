package by.it.bolshakov.jd02_02;

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
                    StringBuilder receipt = new StringBuilder();
                    receipt.append(cashier).append(" started service for ").append(customer).append("\n");
                    double customerTotal = 0;
                    receipt.append("======================================================================" + "\n");
                    for (Good good: customer.getCart().getFromCart()){
                        double price = store.catalog.priceList.get(good);
                        receipt.append(customer).append(" bought ").append(good).append(" for ").append(store.catalog.priceList.get(good)).append("\n");
                        cashier.earn(price);
                        customerTotal+=price;
                    }
                    receipt.append("======================================================================" + "\n");
                    receipt.append(customer).append(" total is ").append(customerTotal).append("\n");
                    receipt.append("======================================================================");
                    int timeout = RandomGenerator.get(
                            MIN_TIMEOUT_SERVICE_CUSTOMER,
                            MAX_TIMEOUT_SERVICE_CUSTOMER
                    );
                    System.out.println(receipt);
                    Sleeper.sleep(timeout);
                    System.out.println(cashier + " finished service for " + customer);
                    customer.setWaiting(false);
                    customer.notify();
                }
            } else {
                Sleeper.sleep(100);
            }
        }
        System.out.printf("%s earned %.2f and in now closing%n", cashier, cashier.getEarnings());
    }
}
