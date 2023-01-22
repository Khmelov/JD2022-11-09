package by.it.han.jd02_03.model;

import by.it.han.jd02_03.util.RandomUtils;

import java.util.HashMap;
import java.util.Map;

public class PriceListRepo {
    private static final int MAX_GOODS_COUNT = 5;
    private static final int MIN_PRICE = 100;
    private static final int MAX_PRICE = 1000;
    private final Map<String, Integer> goods = new HashMap<>();
    private int countName = 0;

    public Map<String, Integer> getGoods() {
        for (int i = 0; i < MAX_GOODS_COUNT; i++) {
            this.goods.put(String.valueOf(++countName), RandomUtils.get(MIN_PRICE, MAX_PRICE));
        }
        return goods;
    }
}
