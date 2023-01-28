package by.it.han.jd02_01;

import java.util.HashMap;
import java.util.Map;

public class Customer {
    private final String name;
    private final PriceListRepo priceListRepo;
    private final Map<String, Integer> goods = new HashMap<>();

    public Customer(String name, int number, PriceListRepo priceListRepo) {
        this.name = name + number;
        this.priceListRepo = priceListRepo;
    }

    public void addGood(int number) {
        for (Map.Entry<String, Integer> entry : priceListRepo.getGoods().entrySet()) {
            if (entry.getKey().equals(String.valueOf(number))) {
                goods.put(entry.getKey(), entry.getValue());
            }
        }
    }

    public int getCountGoods() {
        return goods.size();
    }

    @Override
    public String toString() {
        return name;
    }
}
