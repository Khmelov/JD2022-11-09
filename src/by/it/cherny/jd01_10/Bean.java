package by.it.cherny.jd01_10;

public class Bean {

    double min(int aValue, int bValue){
        return Math.min(aValue, bValue);
    }

    @Param(a=12,b=32)
    static double max(int aValue, int bValue){
        return Math.max(aValue, bValue);
    }

    @Param(a=24,b=35)
    static double sum(int aValue, int bValue){
        return aValue + bValue;
    }

    @Param(a=34,b=15)
    double avg(int aValue, int bValue){
        return (aValue+bValue)/2.0;
    }
}
