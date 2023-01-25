package by.it.cherny.jd02_03.entity;

public record Good(String name, double price) {

    @Override
    public String toString() {
        return "Good:" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
