package by.it.yaroshevich.jd02_03.entity;

public class Customer {

    private final String name;
    private boolean waiting;

    public Customer(int number) {
        this.name = "Customer #" + number;
    }

    public boolean isWaiting() {
        return waiting;
    }

    public void setWaiting(boolean waiting) {
        this.waiting = waiting;
    }

    @Override
    public String toString() {
        return name;
    }
}
