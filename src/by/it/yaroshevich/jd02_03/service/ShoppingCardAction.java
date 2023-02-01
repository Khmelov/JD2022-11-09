package by.it.yaroshevich.jd02_03.service;

import by.it.yaroshevich.jd02_03.entity.Good;

public interface ShoppingCardAction {
    void takeCart();

    int putToCart(Good good);
}
