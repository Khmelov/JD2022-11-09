package by.it._classwork_.jd02_02;

public class Dispatcher {

    private final int MAX_CUSTOMER_COUNT;

    private volatile int countIn=0;
    private volatile int countOut=0;

    public Dispatcher(int max_customer_count) {
        MAX_CUSTOMER_COUNT = max_customer_count;
    }

    public synchronized void addCustomer(){
        countIn++;
    }

    public synchronized void leaveCustomer(){
        countOut++;
    }

    public boolean storeIsOpened(){
        return countIn!=MAX_CUSTOMER_COUNT;
    }

    public boolean storeIsClosed(){
        return countOut==MAX_CUSTOMER_COUNT;
    }
}
