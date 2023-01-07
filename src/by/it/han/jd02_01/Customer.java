package by.it.han.jd02_01;

public class Customer {
    private final String name;
    private int countGoods;

    public Customer(int number) {
        this.name = "Customer #" + number;
        this.countGoods = 0;
    }

    public void addGood() {
        this.countGoods += 1;
    }

    public int getCountGoods() {
        return countGoods;
    }

    @Override
    public String toString() {
        return name;
    }
}
