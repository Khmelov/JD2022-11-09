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
        return cart.stream().map((g) -> PriceListRepo.priceList.get(g)).reduce((g1, g2) -> g1 + g2).orElse(0.0);
    }
}
