package by.it.han.jd02_01;

public class CustomerWorker extends Thread implements CustomerAction {
    private final Store store;
    private final Customer customer;
    private final ShoppingCard shoppingCard;
    public static final double MIN_TIME = 0.5;
    public static final double MIN_TIME_PENSIONER = MIN_TIME * 1.5;
    public static final double MAX_TIME = 2;
    public static final double MAX_TIME_PENSIONER = MAX_TIME * 1.5;
    public static final int MIN_GOOD_COUNT = 2;
    public static final int MIN_GOOD_COUNT_STUDENT = 0;
    public static final int MAX_GOOD_COUNT_STUDENT = 2;
    public static final int MAX_GOOD_COUNT = 5;

    public CustomerWorker(Store store, Customer customer) {
        this.store = store;
        this.customer = customer;
        shoppingCard = new ShoppingCard(store, customer);
    }

    @Override
    public void run() {
        enteredStore();
        shoppingCard.takeCart();
        chooseGood();
        int countGoods;
        if (customer instanceof Student) {
            countGoods = RandomUtils.get(MIN_GOOD_COUNT_STUDENT, MAX_GOOD_COUNT_STUDENT);
        } else {
            countGoods = RandomUtils.get(MIN_GOOD_COUNT, MAX_GOOD_COUNT);
        }
        for (int i = 0; i < countGoods; ) {
            shoppingCard.putToCart(new Good(), ++i);
        }
        goOut();
    }

    @Override
    public void enteredStore() {
        System.out.printf("%s entered to %s%n", customer, store);
    }

    @Override
    public Good chooseGood() {
        if (customer instanceof Pensioner) {
            SleeperUtils.getSleep(MIN_TIME_PENSIONER, MAX_TIME_PENSIONER);
        } else {
            SleeperUtils.getSleep(MIN_TIME, MAX_TIME);
        }
        System.out.printf("%s in %s choose a good%n", customer, store);
        return new Good();
    }

    @Override
    public void goOut() {
        System.out.printf("%s left from %s with %s goods%n", customer, store, customer.getCountGoods());
    }
}
