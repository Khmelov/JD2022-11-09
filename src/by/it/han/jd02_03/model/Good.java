package by.it.han.jd02_03.model;

public class Good {
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
