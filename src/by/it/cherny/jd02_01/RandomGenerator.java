package by.it.cherny.jd02_01;

import java.util.concurrent.ThreadLocalRandom;

public class RandomGenerator {
    public RandomGenerator() {
    }

    public static int get(int startValue, int endValue){
        return ThreadLocalRandom.current()
                .nextInt(startValue, endValue-startValue);
    };

    public static int get(int maxValue){
        return ThreadLocalRandom.current()
                .nextInt(maxValue);
    };
}
