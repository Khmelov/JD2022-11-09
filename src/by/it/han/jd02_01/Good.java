package by.it.han.jd02_01;

public class Good {

    public static final int MAX_PRICE = 1000;
    private final String name;
    private final double price;

    public Good() {
        this.name = String.valueOf(RandomUtils.get(100, 1000));
        this.price = RandomUtils.get(MAX_PRICE);
    }

    public Good(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name;
    }
}
