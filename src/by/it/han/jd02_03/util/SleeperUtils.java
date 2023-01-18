package by.it.han.jd02_03.util;

public class SleeperUtils {
    public static final int MILLI_SEC = 10;

    private SleeperUtils() {

    }

    public static void getSleep(double min, double max) {
        try {
            Thread.sleep(RandomUtils.get(min * MILLI_SEC, max * MILLI_SEC));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void getSleep(double value) {
        try {
            Thread.sleep(RandomUtils.get(0, value * MILLI_SEC));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
