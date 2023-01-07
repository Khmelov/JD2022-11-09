package by.it.han.jd02_01;

public class Good {

    private final String name;
    private final int price;

    public Good() {
        this.name = "Notebook";
        this.price = 10;
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
