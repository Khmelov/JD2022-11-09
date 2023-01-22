package by.it.cherny.jd02_03.util;

import java.util.concurrent.ThreadLocalRandom;

public class RandomGenerator {
    public RandomGenerator() {
    }

    public static int get(int startValue, int endValue){
        return ThreadLocalRandom.current()
                .nextInt(startValue, endValue+1);
    }

    public static int get(int maxValue){
        return ThreadLocalRandom.current()
                .nextInt(maxValue+1);
    }
}
