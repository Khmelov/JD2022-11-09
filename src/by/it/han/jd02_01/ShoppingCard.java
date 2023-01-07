package by.it.han.jd02_01;

public class ShoppingCard implements ShoppingCardAction {
    private final Store store;
    private final Customer customer;
    public static final double MIN_TIME_BETWEEN_ADD_TO_CARD = 0.1;
    public static final double MAX_TIME_BETWEEN_ADD_TO_CARD = 0.3;

    public ShoppingCard(Store store, Customer customer) {
        this.store = store;
        this.customer = customer;
    }

    @Override
    public void takeCart() {
        System.out.printf("%s in %s  take cart%n", customer, store);
    }

    @Override
    public int putToCart(Good good, int indexGood) {
        System.out.printf("%s put %d good to Cart in store %s%n", customer, indexGood, store);
        customer.addGood(good);
        SleeperUtils.getSleep(MIN_TIME_BETWEEN_ADD_TO_CARD, MAX_TIME_BETWEEN_ADD_TO_CARD);
        return customer.getCountGoods();
    }
}
