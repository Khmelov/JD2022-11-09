package by.it.han.jd02_01;

public class Runner {
    public static void main(String[] args) {
        Store store = new Store("Euroopt");
        store.start();
        Store store1 = new Store("Sosedi");
        store1.start();
    }
}
