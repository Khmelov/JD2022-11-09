package by.it.bolshakov.jd02_03.entity;

public class Good {

    private final String name;
    private final double price;

    public Good(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Good{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
