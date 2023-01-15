package by.it.han.jd02_02;

public class Runner {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            Manager manager = new Manager(100);
            CustomerQueue customerQueue = new CustomerQueue();
            Store store = new Store("Euroopt" + i, manager, customerQueue);
            store.start();
        }
    }
}
