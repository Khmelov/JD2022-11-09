package by.it.yaroshevich.jd02_02;

import java.util.Map;
import java.util.Set;

public class CustomerWorker extends Thread implements CustomerAction, ShoppingCardAction {
    public static final int MAX_TIMEOUT = 2000;
    public static final int MIN_TIMEOUT = 500;
    public static final int MIN_TIME_FOR_OPERATION_WITH_CART = 100;
    public static final int MAX_TIME_FOR_OPERATION_WITH_CART = 300;
    public static final int MIN_COUNT_GOODS = 2;
    public static final int MAX_COUNT_GOODS = 5;
    private final Customer customer;
    private final Store store;
    private ShoppingCart shoppingCart;
    private final Dispatcher dispatcher;
    private final CustomerQueue customerQueue;

    public CustomerWorker(Store store, Customer customer) {
        this.store = store;
        this.customer = customer;
        shoppingCart = null;
        dispatcher = store.getDispatcher();
        customerQueue = store.getCustomerQueue();
        dispatcher.enteredCustomer();
    }

    @Override
    public void enteredStore() {
        System.out.println(customer + "entered to the " + store);

    }

    @Override
    public Good chooseGood() {
        int timeout = RandomGenerator.get(MIN_TIMEOUT, MAX_TIMEOUT);
        Sleeper.sleep(timeout);
        Map<String, Double> priceListOfProducts = PriceListRepo.getNameGoodWithPrice();
        Set<String> setListOfGoods = priceListOfProducts.keySet();
        String[] stringListOfGoods = new String[setListOfGoods.size()];
        setListOfGoods.toArray(stringListOfGoods);
        int numberOfGood = RandomGenerator.get(stringListOfGoods.length - 1);
        Good good = new Good(stringListOfGoods[numberOfGood]);
        System.out.println(customer + " choose good - " + good);
        return good;
    }

    @Override
    public void goOut() {
        System.out.println(customer + " left the " + store);

    }

    @Override
    public void takeCart() {
        int timeout = RandomGenerator.get(MIN_TIME_FOR_OPERATION_WITH_CART, MAX_TIME_FOR_OPERATION_WITH_CART);
        Sleeper.sleep(timeout);
        this.shoppingCart = new ShoppingCart(customer);
        System.out.println(customer + " took a cart");
    }

    @Override
    public int putToCart(Good good) {
        int timeout = RandomGenerator.get(MIN_TIME_FOR_OPERATION_WITH_CART, MAX_TIME_FOR_OPERATION_WITH_CART);
        Sleeper.sleep(timeout);
        System.out.println(customer + " put goods " + good + " in cart");
        System.out.println(customer + " take " + shoppingCart.addToCart(good));
        return shoppingCart.goodsInCart.size();
    }

    @Override
    public void run() {
        enteredStore();
        takeCart();
        int randomCountGoods = RandomGenerator.get(MIN_COUNT_GOODS, MAX_COUNT_GOODS);
        for (int i = 0; i < randomCountGoods; i++) {
            chooseGood();
            putToCart(chooseGood());
        }
        goToQueue();
        goOut();
        dispatcher.leftCustomer();
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
}
