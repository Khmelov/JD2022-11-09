package by.it.bolshakov.jd02_01;

import java.util.Random;

public class CustomerWorker extends Thread implements CustomerAction, ShoppingCartAction {
    private static final int MIN_TIMEOUT = 100;
    private static final int MAX_TIMEOUT = 300;
    private static final int MIN_GOODS = 2;
    private static final int MAX_GOODS = 5;
    private static final int timeout = RandomGenerator.get(MIN_TIMEOUT, MAX_TIMEOUT);
    private final Store store;
    private final Customer customer;
    private ShoppingCart cart;

    public CustomerWorker(Store store, Customer customer) {
        this.store = store;
        this.customer = customer;
    }

    @Override
    public void enteredStore() {
        System.out.println(customer + " заходит в " + store);
    }

    @Override
    public Good chooseGood() {
        Sleeper.sleep(timeout);
        Good good = PriceListRepo
                        .priceList
                        .keySet()
                        .stream()
                        .skip( new Random().nextInt(PriceListRepo.priceList.keySet().size()) )
                        .findFirst()
                        .orElse(null);
        System.out.println(customer.toString() + " выбрал " + good.toString());
        return good;
    }

    @Override
    public void goOut() {
        System.out.println(customer + " уходит из " + store);
    }

    @Override
    public void takeCart() {
        Sleeper.sleep(timeout);
        cart = new ShoppingCart();
        System.out.println(customer.toString() + " взял корзину");
    }

    @Override
    public int putToCart(Good good) {
        Sleeper.sleep(timeout);
        cart.addToCart(good);
        return cart.countItems();
    }

    @Override
    public void run() {
        enteredStore();
        takeCart();
        for (int i = 0; i < RandomGenerator.get(MIN_GOODS, MAX_GOODS); i++) {
            System.out.println("В корзине " + customer.toString() + " " + putToCart(chooseGood()) + " товаров");
        }
        System.out.printf("Сумма покупок %s = %.2f\n", customer.toString(), cart.countTotal());
        goOut();
    }
}
