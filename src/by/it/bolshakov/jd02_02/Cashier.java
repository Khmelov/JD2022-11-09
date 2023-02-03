package by.it.bolshakov.jd02_02;

public class Cashier {
    private final String name;

    private double earnings;

    public Cashier(int number) {
        this.name = "\tCashier #" + number;
        this.earnings = 0;
    }

    public double getEarnings() {
        return earnings;
    }

    public void earn(double price) {
        earnings+=price;
    }

    @Override
    public String toString() {
        return name;
    }
}
