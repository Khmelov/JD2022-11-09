package by.it.cherny.jd02_03.entity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Customer {

    private final String name;
    private final ShoppingCart shoppingCart;
    private boolean waiting;

//    ExecutorService executors = Executors.newFixedThreadPool(50);

    public Customer(int number) {
        if (number%4==0){
            this.name = "Pensioner #"+number;
        } else if (number%2==0) {
            this.name = "Student #"+number;
        } else {
            this.name = "Customer #"+number;
        }
        shoppingCart = new ShoppingCart(this);
    }


    public Object getMonitor(){
        return this;
    }
    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public String getName() {
        return name;
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
