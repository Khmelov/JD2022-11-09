package by.it.bolshakov.jd02_01;

public class Customer {

    private final String name;

    public Customer(int number) {
        this.name = "Покупатель #" + number;
    }

    @Override
    public String toString() {
        return name;
    }
}
