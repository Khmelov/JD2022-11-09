package by.it.bolshakov.jd02_02;

public class Customer {

    private final String name;
    private boolean waiting;
    private ShoppingCart cart;
    public boolean hasCart() {
        return cart != null;
    }
    public boolean isWaiting() {
        return waiting;
    }


    public void setWaiting(boolean waiting) {
        this.waiting = waiting;
    }
    public ShoppingCart getCart() {
        return cart;
    }

    public Customer(int number, boolean cart) {
        this.name = "Customer #"+number;
        if (cart){
            this.cart = new ShoppingCart();
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
