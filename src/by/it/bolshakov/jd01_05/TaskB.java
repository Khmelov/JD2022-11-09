package by.it.bolshakov.jd01_05;

import static java.lang.Math.*;

public class TaskB {

    private static void task4() {

        for (double a = 0;  a <= 2 ; a+=0.2) {
            double y = 0;
            for (int x = 1; x < 7; x++) {
                y = y + pow(7, a) - cos(x);
            }
            System.out.printf("При a=%.2f Сумма y=%.4f%n",a,y);
        }
    }
    private static void task5() {
        for (double x = -5.5; x < 2 ; x+=0.5) {
            if ((x/2 > -2) & (x/2 <= -1)) {
                double a = log10(abs(sin(pow(x,2))+2.74));
                System.out.printf("При x/2=%f a=%f%n",x/2, a);
            } else if ((x/2 > -1) & (x/2 < 0.2)) {
                double a = log10(abs(cos(pow(x,2))+2.74));
                System.out.printf("При x/2=%f a=%f%n",x/2, a);
            } else if (x/2==0.2) {
                double a = log10(abs(1.0/tan(pow(x,2))+2.74));
                System.out.printf("При x/2=%f a=%f%n",x/2, a);
            } else {
                System.out.printf("При x/2=%f вычисления не определены%n",x/2);
            }
        }
    }

    public static void main(String[] args) {
        task4();
        task5();
    }
}
