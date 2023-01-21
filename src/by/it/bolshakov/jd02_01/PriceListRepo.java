package by.it.bolshakov.jd02_01;

import java.util.HashMap;

public class PriceListRepo {
    public static final HashMap<Good, Double> priceList;

    static {
        priceList = new HashMap<>();
        priceList.put(new Good("Доширак"), 1.0);
        priceList.put(new Good("Молоко"), 1.7);
        priceList.put(new Good("Батон"), 0.3);
        priceList.put(new Good("Масло"), 2.0);
        priceList.put(new Good("Кола"), 2.4);
    }

    private PriceListRepo() {
    }
}
