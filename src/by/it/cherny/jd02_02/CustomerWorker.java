package by.it.cherny.jd02_02;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class CustomerWorker extends Thread implements CustomerAction {

    public static final int MIN_GOOD_CHOOSING_TIMEOUT = 500;
    public static final int MAX_GOOD_CHOOSING_TIMEOUT = 2000;
    public static final Map<String, Double> PRICE_LIST = PriceListRepo.getList();
    public static final int MIN_CART_GOODS = 2;
    public static final int MAX_CART_GOODS = 5;
    public static final int MIN_OPERATION_TIMEOUT = 100;
    public static final int MAX_OPERATION_TIMEOUT = 300;
    private final Customer customer;
    private final Store store;
    private final Dispatcher dispatcher;
    private final CustomerQueue customerQueue;
    private final ShoppingCart shoppingCart;

    public CustomerWorker(Store store, Customer customer) {
        this.store = store;
        this.customer = customer;
        shoppingCart = customer.getShoppingCart();
        dispatcher = store.getDispatcher();
        customerQueue = store.getCustomerQueue();
        dispatcher.addCustomer();
    }

    @Override
    public void run() {
        enteredStore();
        shoppingCart.takeCart();
        chooseGood();
        goToQueue();
        goOut();
        dispatcher.leaveCustomer();
    }

    @Override
    public void enteredStore() {
        System.out.println(customer+" entered the store "+store);
    }

    @Override
    public Good chooseGood() {
        System.out.println(customer+" has started choosing the product ");
        int timeout=RandomGenerator.get(MIN_GOOD_CHOOSING_TIMEOUT, MAX_GOOD_CHOOSING_TIMEOUT);
        Sleeper.sleep(timeout);
        int choosingTimeout=RandomGenerator.get(MIN_OPERATION_TIMEOUT, MAX_OPERATION_TIMEOUT);
        int countOfGoods=RandomGenerator.get(MIN_CART_GOODS, MAX_CART_GOODS);

        setTimeoutByCustomer(customer.getName(), timeout, choosingTimeout, countOfGoods);

        for (int i = 0; i < countOfGoods; i++) {
            int goodsCount = shoppingCart.putToCart(getRandomGood());
            System.out.println("There is "+goodsCount+" goods in the "+customer+" cart");
            Sleeper.sleep(choosingTimeout);
        }
        System.out.println(customer+" has finished choosing the product ");
        return null;
    }

    private void setTimeoutByCustomer(String customerName, int timeout, int choosingTimeout, int countOfGoods) {
        if (customerName.contains("Pensioner")){
            timeout*=1.5;
            choosingTimeout*=1.5;
        } else if (customerName.contains("Student")) {
            countOfGoods=RandomGenerator.get(2);
            if (countOfGoods==0){
                System.out.println(customerName+" has finished choosing the product ");
            }
        }
    }

    @Override
    public void goToQueue() {
        synchronized (customer){
            customerQueue.add(customer);
            customer.setWaiting(true);
            while (customer.isWaiting()){
                try {
                    customer.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
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

}
