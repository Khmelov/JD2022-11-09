package by.it.han.player.util;

import java.util.concurrent.ThreadLocalRandom;

public class RandomUtil {

    private RandomUtil() {

    }

    public static int get(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
