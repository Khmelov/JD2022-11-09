package by.it.samatokhin.jd02_02;

public class Customer {

    private final String name;
    private boolean waiting;

    public boolean isWaiting() {
        return waiting;
    }

    public void setWaiting(boolean waiting) {
        this.waiting = waiting;
    }

    public Customer(int number) {
        this.name = "Customer #" + number;
    }

    @Override
    public String toString() {
        return name;
    }
}
