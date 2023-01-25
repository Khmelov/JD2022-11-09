package by.it.cherny.jd02_03.util;

public class Sleeper {

    public static final int K_SPEED = 50;

    public Sleeper() {
    }
    public static void sleep(int mills){
        try {
            Thread.sleep(mills / K_SPEED);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
