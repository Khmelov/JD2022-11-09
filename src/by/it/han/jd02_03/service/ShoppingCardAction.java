package by.it.han.jd02_03.service;

import by.it.han.jd02_03.model.Good;

public interface ShoppingCardAction {
    void takeCart();
    int putToCart(Good good, int num);
}
