package by.it.han.jd02_02;

import java.util.HashMap;
import java.util.Map;

public class Customer {
    private final String name;
    private boolean waiting;
    private final PriceListRepo priceListRepo;
    private final Map<String, Integer> goods = new HashMap<>();

    public Customer(int number, PriceListRepo priceListRepo) {
        this.name = "Customer #" + number;
        this.priceListRepo = priceListRepo;
    }

    public void addGood(int number) {
        for (Map.Entry<String, Integer> entry : priceListRepo.getGoods().entrySet()) {
            if (entry.getKey().equals(String.valueOf(number))) {
                goods.put(entry.getKey(), entry.getValue());
            }
        }
    }

    public boolean isWaiting() {
        return waiting;
    }

    public void setWaiting(boolean waiting) {
        this.waiting = waiting;
    }

    public int getCountGoods() {
        return goods.size();
    }

    @Override
    public String toString() {
        return name;
    }
}
