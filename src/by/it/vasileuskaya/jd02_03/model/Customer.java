package by.it.vasileuskaya.jd02_03.model;

public class Customer {

    private final String name;
    private boolean waiting;

    public Customer(int number) {
        this.name = "Customer #" + number;
    }

    @Override
    public String toString() {
        return name;
    }

    public boolean isWaiting() {
        return waiting;
    }

    public void setWaiting(boolean waiting) {
        this.waiting = waiting;
    }
}
