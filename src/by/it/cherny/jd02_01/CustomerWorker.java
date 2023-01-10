package by.it.cherny.jd02_01;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class CustomerWorker extends Thread implements CustomerAction, ShoppingCardAction{

    public static final int MIN_TIMEOUT = 500;
    public static final int MAX_TIMEOUT = 2000;
    public static final Map<String, Double> PRICE_LIST = PriceListRepo.getList();
    public static final int MIN_CART_GOODS = 2;
    public static final int MAX_CART_GOODS = 5;
    private final Customer customer;
    private final Store store;
    private int countOfGoods=0;

    public CustomerWorker(Store store, Customer customer) {
        this.store = store;
        this.customer = customer;
    }

    @Override
    public void run() {
        enteredStore();
        takeCart();
        chooseGood();
        goOut();
    }

    @Override
    public void enteredStore() {
        System.out.println(customer+" entered the store "+store);
    }

    @Override
    public Good chooseGood() {
        System.out.println(customer+" has started choosing the product ");
        int timeout=RandomGenerator.get(MIN_TIMEOUT, MAX_TIMEOUT);
        Sleeper.sleep(timeout);
        int choosingTimeout=RandomGenerator.get(100, 300);
        int countOfGoods=RandomGenerator.get(MIN_CART_GOODS, MAX_CART_GOODS);
        for (int i = 0; i < countOfGoods; i++) {
            int goodsCount = putToCart(getRandomGood());
            System.out.println("There is "+goodsCount+" goods in the "+customer+" cart");
            Sleeper.sleep(choosingTimeout);
        }
        System.out.println(customer+" has finished choosing the product ");
        return null;
    }

    private Good getRandomGood() {
        int MAX_COUNT_OF_GOODS=PRICE_LIST.size();
        int goodNumber=RandomGenerator.get(1,MAX_COUNT_OF_GOODS);
        Set<String> goods = PRICE_LIST.keySet();
        Collection<Double> prices = PRICE_LIST.values();
        String productName = goods.stream().skip(goodNumber-1).findFirst().get();
        Double price = prices.stream().skip(goodNumber-1).findFirst().get();
        return new Good(productName, price);
    }

    @Override
    public void goOut() {
        System.out.println(customer+" leaves the store "+store);
    }

    @Override
    public void takeCart() {
        System.out.println(customer+" take the cart");
        int timeout=RandomGenerator.get(100, 300);
        Sleeper.sleep(timeout);
    }

    @Override
    public int putToCart(Good good) {
        System.out.println(customer+" add "+good+" to cart");
        this.countOfGoods++;
        return countOfGoods;
    }
}
