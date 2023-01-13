package by.it.vasileuskaya.jd02_02;

public class Runner {
    public static void main(String[] args) {
        Dispatcher dispatcher = new Dispatcher(100);
        CustomerQueue customerQueue = new CustomerQueue();
        Store store = new Store("Biedronka", dispatcher, customerQueue);
        store.start();
    }
}
