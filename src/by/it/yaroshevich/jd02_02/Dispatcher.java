package by.it.yaroshevich.jd02_02;

public class Dispatcher {
    private final int MAX_CUSTOMER_COUNT;
    private volatile int countIn = 0;
    private volatile int countOut = 0;

    public Dispatcher(int max_customer_count) {
        MAX_CUSTOMER_COUNT = max_customer_count;
    }

    public synchronized void enteredCustomer() {
        countIn++;
    }

    public synchronized void leftCustomer() {
        countOut++;
    }

    public boolean storeIsOpen() {
        return countIn != MAX_CUSTOMER_COUNT;
    }

    public boolean storeIsClose() {
        return countOut == MAX_CUSTOMER_COUNT;
    }
}
