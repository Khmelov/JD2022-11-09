package by.it.samatokhin.jd01_10;

public class Bean {

    double min(int aValue, int bValue) {
        return Math.min(aValue, bValue);
    }

    @Param(a = 34, b = 12)
    static double max(int aValue, int bValue) {
        return Math.max(aValue, bValue);
    }

    @Param(a = 24, b = 56)
    static double sum(int aValue, int bValue) {
        return aValue + bValue;
    }

    @Param(a = 11, b = 12)
    double avg(int aValue, int bValue) {
        return sum(aValue, bValue) / 2;
    }

    @Override
    public String toString() {
        return "Bean{}";
    }
}
