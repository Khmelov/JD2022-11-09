package by.it.bolshakov.jd02_01;

public class Sleeper {

    private static final int K_SPEED = 50;

    private Sleeper() {

    }

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis/ K_SPEED);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
