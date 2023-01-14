package by.it.han.jd02_01;

public class Good {

    public static final int MAX_PRICE = 1000;
    public static final int MIN_PRICE = 100;
    private final String name;
    private final int price;

    public Good() {
        this.name = String.valueOf(RandomUtils.get(MIN_PRICE, MAX_PRICE));
        this.price = RandomUtils.get(MIN_PRICE, MAX_PRICE);
    }

    public Good(String name, int price) {
        this.name = name;
        this.price = price;
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
