package by.it.bolshakov.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Good> cart;

    public ShoppingCart() {
        this.cart = new ArrayList<>();
    }

    public void addToCart (Good good) {
        cart.add(good);
    }

    public int countItems () {
        return cart.size();
    }

    public double countTotal () {
        return cart.stream().map(PriceListRepo.priceList::get).reduce(Double::sum).orElse(0.0);
    }
}
