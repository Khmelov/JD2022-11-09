package by.it.cherny.jd02_02;

import java.util.List;

public class CashierWorker implements Runnable{

    public static final int MIN_SERVICE_CUSTOMER_TIMEOUT = 2000;
    public static final int MAX_SERVICE_CUSTOMER_TIMEOUT = 5000;
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
        System.out.println(cashier+" opened");
        while (!dispatcher.storeIsClosed()){
            Customer customer = customerQueue.poll();
            if (customer!=null){
                synchronized (customer){
                    System.out.println(cashier+" started service for "+customer);
                    int timeout = RandomGenerator.get(
                            MIN_SERVICE_CUSTOMER_TIMEOUT,
                            MAX_SERVICE_CUSTOMER_TIMEOUT
                    );
                    Sleeper.sleep(timeout);

                    List<Good> goodList = customer.getShoppingCart().getCartList();
                    Double totalCustomerAmount = getCustomerAmount(goodList);

                    cashier.setTotalRevenue(cashier.getTotalRevenue()+totalCustomerAmount);
                    System.out.println(customer+" cheque");
                    System.out.println("Total amount: "+totalCustomerAmount);
                    getCheque(goodList.toArray());
                    System.out.println(cashier+" finished service for "+customer);
                    customer.setWaiting(false);
                    customer.notify();
                }
            } else {
                Thread.onSpinWait();
            }
        }
        System.out.println("Total revenue "+cashier+" "+cashier.getTotalRevenue());
        System.out.println(cashier+" closed");
    }

    private void getCheque(Object[] goods) {
        StringBuilder builder = new StringBuilder();
        for (Object good : goods) {
            builder.append(good.toString()
                    .replaceAll("Good\\{name=", "")
                    .replaceAll("[{},']", "")
            );
            builder.append(System.lineSeparator());
        }
        System.out.println(builder);
    }

    private double getCustomerAmount(List<Good> goodList) {
        Double revenue = 0.0;
        for (Good good : goodList) {
            revenue+=good.getPrice();
        }
        return revenue;
    }
}
