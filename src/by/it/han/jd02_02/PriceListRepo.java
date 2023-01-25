package by.it.han.jd02_02;

import java.util.HashMap;
import java.util.Map;

public class PriceListRepo {
    private final Map<String, Integer> goods = new HashMap<>();
    private int countName = 0;

    public Map<String, Integer> getGoods() {
        for (int i = 0; i < 5; i++) {
            this.goods.put(String.valueOf(++countName), RandomUtils.get(100, 1000));
        }
        return goods;
    }
}
