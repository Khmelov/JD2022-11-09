package by.it.han.jd02_01;

public class CustomerWorker extends Thread implements CustomerAction {
    private final Store store;
    private final Customer customer;
    public static final double MIN_TIME = 0.5;
    public static final int MAX_TIME = 2;

    public CustomerWorker(Store store, Customer customer) {
        this.store = store;
        this.customer = customer;
    }

    @Override
    public void run() {
        enteredStore();
        chooseGood();
        goOut();
    }

    @Override
    public void enteredStore() {
        System.out.println("Customer " + customer + " entered to " + store);
    }

    @Override
    public Good chooseGood() {
        SleeperUtils.getSleep(MIN_TIME, MAX_TIME);
        System.out.println("Customer " + customer + " choose a good");
        return new Good();
    }

    @Override
    public void goOut() {
        System.out.println("Customer " + customer + " left " + store);
    }
}
