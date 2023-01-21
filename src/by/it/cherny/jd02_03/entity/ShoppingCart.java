package by.it.cherny.jd02_03.entity;

import by.it.cherny.jd02_03.util.RandomGenerator;
import by.it.cherny.jd02_03.util.Sleeper;
import by.it.cherny.jd02_03.service.ShoppingCartAction;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart implements ShoppingCartAction {

    private int countOfGoods=0;
    private final Customer customer;
    private final List<Good> cartList = new ArrayList<>();

    public ShoppingCart(Customer customer) {
        this.customer = customer;
    }

    public List<Good> getCartList() {
        return cartList;
    }

    @Override
    public void takeCart() {
        System.out.println(customer+" take the cart");
        int timeout= RandomGenerator.get(100, 300);
        Sleeper.sleep(timeout);
    }

    @Override
    public int putToCart(Good good) {
        System.out.println(customer+" add "+good+" to cart");
        cartList.add(good);
        this.countOfGoods++;
        return countOfGoods;
    }
}
