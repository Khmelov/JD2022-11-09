package by.it.cherny.jd02_02;

import java.util.HashMap;
import java.util.Map;

public class PriceListRepo{
    public static Map<String, Double> list = new HashMap<>();

    public static void setList(Map<String, Double> list) {
        PriceListRepo.list = list;
    }

    public static Map<String, Double> getList() {
        return list;
    }

    public PriceListRepo() {
        list.put("ice-cream", 2.0);
        list.put("sausages", 4.5);
        list.put("bread", 1.3);
        list.put("meat", 9.99);
        list.put("eggs", 2.01);
        list.put("sauce", 1.5);
        list.put("sushi", 10.2);
        list.put("pizza", 15.0);
    }
}
