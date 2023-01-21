package by.it.cherny.jd02_03.service;

import by.it.cherny.jd02_03.entity.Good;

public interface ShoppingCartAction {
    void takeCart();
    int putToCart(Good good);
}
