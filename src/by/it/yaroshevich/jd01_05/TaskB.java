package by.it.yaroshevich.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
    }

    public static void step1() {
        double x = 0;
        double y = 0;
        double a = 0;
        for (double i = 1; i <= 6; i++) {
            for (double j = 0; j < 2; j+=0.2) {
                x=x+i;
                a=a+0.2;
                y = x * (pow(7, a) - cos(x));

        }
            System.out.printf("При a=%-3.2f Сумма y = %f%n", a,y);
        }
    }
}
