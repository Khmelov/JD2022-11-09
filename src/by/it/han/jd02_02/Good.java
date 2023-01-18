package by.it.han.jd02_02;

public class Good {

    public static final int MAX_PRICE = 1000;
    public static final int MIN_PRICE = 100;
    private final String name;
    private final int price;

    public Good(String name, PriceListRepo priceListRepo) {
        this.name = name;
        this.price = priceListRepo.getGoods().get(name);
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name;
    }
}
