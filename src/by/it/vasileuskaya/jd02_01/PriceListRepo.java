package by.it.vasileuskaya.jd02_01;

import java.util.HashMap;
import java.util.Map;

public class PriceListRepo {
    public static Map<String, Double> getNameGoodWithPrice() {
        Map<String, Double> nameGoodWithPrice = new HashMap<>();
        nameGoodWithPrice.put("Milk", 3.5);
        nameGoodWithPrice.put("Soy milk", 4.5);
        nameGoodWithPrice.put("Yeast bread", 3.0);
        nameGoodWithPrice.put("Whole wheat bread", 4.5);
        nameGoodWithPrice.put("Noodle", 3.7);
        nameGoodWithPrice.put("Whole wheat noodles", 4.0);
        nameGoodWithPrice.put("Pork sausage", 2.2);
        nameGoodWithPrice.put("Bean sausage", 3.0);
        nameGoodWithPrice.put("Natural artesian water", 0.7);
        nameGoodWithPrice.put("Sparkling water", 0.9);
        return nameGoodWithPrice;
    }
}
