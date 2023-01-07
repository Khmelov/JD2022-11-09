package by.it._classwork_.jd02_01;

public class Customer {

    private final String name;

    public Customer(int number) {
        this.name = "Customer #"+number;
    }

    @Override
    public String toString() {
        return name;
    }
}
