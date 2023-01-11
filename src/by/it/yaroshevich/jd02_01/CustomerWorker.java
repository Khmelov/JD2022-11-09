package by.it.yaroshevich.jd02_01;

public class CustomerWorker extends Thread implements CustomerAction{
    public static final int MAX_TIMEOUT = 2000;
    public static final int MIN_TIMEOUT = 500;
    private final Store store;
    private final Customer customer;


    @Override
    public void run() {
        enteredStore();
        chooseGood();
        goOut();

    }

    public CustomerWorker(Store store, Customer customer) {
        this.store = store;
        this.customer = customer;
    }


    @Override
    public void enteredStore() {
        System.out.println(customer + "entered to the " + store);

    }

    @Override
    public Good chooseGood() {
        System.out.println(customer + "started to choose goods");
        int timeout = RandomGenerator.get(MIN_TIMEOUT, MAX_TIMEOUT);
        Sleeper.sleep(timeout);
        System.out.println(customer + "finished to choose goods");
        return null;
    }

    @Override
    public void goOut() {
        System.out.println(customer + "leaves the " + store);

    }
}
