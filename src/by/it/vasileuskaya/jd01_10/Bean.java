package by.it.vasileuskaya.jd01_10;

public class Bean {
    @Param(a = 2, b = 5)
    static double min(int aValue, int bValue) {
        return Math.min(aValue, bValue);
    }

    @Param(a = 2, b = 5)
    static double max(int aValue, int bValue) {
        return Math.max(aValue, bValue);
    }

    @Param(a = 2, b = 5)
    double sum(int aValue, int bValue) {
        return aValue + bValue;
    }

    double avg(int aValue, int bValue) {
        return (aValue + bValue) / 2.0;
    }
}
