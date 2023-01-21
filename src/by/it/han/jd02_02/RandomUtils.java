package by.it.han.jd02_02;

import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    public static final int MIN_VALUE = 0;

    private RandomUtils() {
    }

    public static int get(double min, double max) {
        return (int) ThreadLocalRandom.current().nextDouble(min, max + 1);
    }

    public static int get(double max) {
        return (int) ThreadLocalRandom.current().nextDouble(MIN_VALUE, max + 1);
    }
}
