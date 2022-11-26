package by.it.yaroshevich.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
    }

    private static void step1() {
        for (double x = 1; x <= 6; x++) {
        for (double a = 0; a <= 2; a=a+0.2){
            double y = (x * x) * pow(7, a) - cos(x);
            System.out.printf("При a=%-3.2f Сумма y=%f", a,y);
        }
        }
    }
}
