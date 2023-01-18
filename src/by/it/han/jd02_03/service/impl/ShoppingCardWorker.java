package by.it.han.jd02_03.service.impl;

import by.it.han.jd02_03.model.Customer;
import by.it.han.jd02_03.model.Good;
import by.it.han.jd02_03.model.ShoppingCard;
import by.it.han.jd02_03.model.Store;
import by.it.han.jd02_03.service.ShoppingCardAction;
import by.it.han.jd02_03.util.SleeperUtils;

import static by.it.han.jd02_03.util.StringsConstantUtils.PUT_GOOD;
import static by.it.han.jd02_03.util.StringsConstantUtils.TAKE_CART;

public class ShoppingCardWorker implements ShoppingCardAction {
    private static final double MIN_TIME_BETWEEN_ADD_TO_CARD = 0.1;
    private static final double MAX_TIME_BETWEEN_ADD_TO_CARD = 0.3;
    private final Customer customer;
    private final Store store;

    public ShoppingCardWorker(ShoppingCard shoppingCard) {
        store = shoppingCard.store();
        customer = shoppingCard.customer();
    }

    @Override
    public void takeCart() {
        System.out.printf(TAKE_CART, customer, store);
    }

    @Override
    public int putToCart(Good good, int num) {
        customer.addGood(num);
        System.out.printf(PUT_GOOD, customer, num,
                good.getName(), good.getPrice(), store);
        SleeperUtils.getSleep(MIN_TIME_BETWEEN_ADD_TO_CARD, MAX_TIME_BETWEEN_ADD_TO_CARD);
        return customer.getCountGoods();
    }
}
