package by.it.bolshakov.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private final List<Good> cart;

    public ShoppingCart() {
        this.cart = new ArrayList<>();
    }

    public void addToCart (Good good) {
        cart.add(good);
    }

    public List<Good> getFromCart() {
        return cart;
    }

}
