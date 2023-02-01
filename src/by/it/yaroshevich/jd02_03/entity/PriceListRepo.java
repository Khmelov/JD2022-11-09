package by.it.yaroshevich.jd02_03.entity;

import java.util.HashMap;
import java.util.Map;

public class PriceListRepo {
    public static Map<String, Double> getNameGoodWithPrice() {
        Map<String, Double> nameGoodWithPrice = new HashMap<>();
        nameGoodWithPrice.put("Milk", 2.9);
        nameGoodWithPrice.put("Bread", 1.9);
        nameGoodWithPrice.put("Meet", 12.9);
        nameGoodWithPrice.put("Chocolate", 3.9);
        nameGoodWithPrice.put("Cake", 4.9);
        return nameGoodWithPrice;
    }
}
