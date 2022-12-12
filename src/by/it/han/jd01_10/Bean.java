package by.it.han.jd01_10;

public class Bean {

    @Param(a = 2, b = 4)
    public static double sum(int a, int b) {
        return a + b;
    }

    @Param(a = 2, b = 4)
    public double max(int a, int b) {
        return Math.max(a, b);
    }

    @Param(a = 2, b = 4)
    public double min(int a, int b) {
        return Math.min(a, b);
    }

    public static double avg(int a, int b) {
        return sum(a, b) / 2;
    }
}
