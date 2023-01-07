package by.it.han.jd02_01;

import java.util.HashMap;
import java.util.Map;

public class Customer implements PriceListRepo {
    private final String name;
    private final Map<Good, Integer> goods = new HashMap<>();

    public Customer(int number) {
        this.name = "Customer #" + number;
    }

    @Override
    public void addGood(Good good) {
        this.goods.put(good, good.getPrice());
    }

    public int getCountGoods() {
        return goods.size();
    }

    @Override
    public String toString() {
        return name;
    }
}
