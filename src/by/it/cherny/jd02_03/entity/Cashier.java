package by.it.cherny.jd02_03.entity;

public class Cashier {
    private final String name;
    private Double totalRevenue =0.0;

    public Cashier(int number) {
        this.name = "\tCashier #"+ number;
    }

    public Double getTotalRevenue() {
        return this.totalRevenue;
    }

    public void setTotalRevenue(double revenue) {
        this.totalRevenue = revenue;
    }

    @Override
    public String toString() {
        return name;
    }
}
