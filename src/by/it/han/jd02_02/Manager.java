package by.it.han.jd02_02;

public class Manager {
    private final int MAX_CUSTOMER_COUNT;
    private volatile int customerCountIn = 0;
    private volatile int customerCountOut = 0;

    public Manager(int max_customer_count) {
        MAX_CUSTOMER_COUNT = max_customer_count;
    }

    public synchronized void addCustomer() {
        customerCountIn++;
    }

    public synchronized void leaveCustomer() {
        customerCountOut++;
    }

    public boolean storeIsOpened() {
        return customerCountIn != MAX_CUSTOMER_COUNT;
    }

    public boolean storeIsClosed() {
        return customerCountOut == MAX_CUSTOMER_COUNT;
    }
}
