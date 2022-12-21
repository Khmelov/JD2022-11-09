package by.it.bolshakov.jd01_10;

public class Bean {
    static double min (int a, int b) {return Math.min(a,b);};
    @Param(a=34, b=12)
    static double max (int a, int b) {return Math.max(a,b);};
    @Param(a=23,b=1)
    double sum (int a, int b) {return a+b;};
    @Param(a=23,b=1)
    double avg (int a, int b) {return sum(a, b)/2.0;};
}

