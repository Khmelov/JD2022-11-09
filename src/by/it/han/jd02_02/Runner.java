package by.it.han.jd02_02;

public class Runner {
    public static void main(String[] args) {
            Manager manager = new Manager(100);
            CustomerQueue customerQueue = new CustomerQueue();
            Store store = new Store("Euroopt", manager, customerQueue);
            store.start();
    }
}
