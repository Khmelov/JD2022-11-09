package by.it.cherny.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step2() {
        double deltaX = 0.5;
        double b = 0;
        for (double x = -6 + deltaX; x < 2; x += deltaX) {
            if (x / 2 == 0.2) {
                b = 1 / tan(pow(x, 2));
            } else if (-1 < x / 2 && x / 2 < 0.2) {
                b = cos(pow(x, 2));
            } else if (-2 < x / 2 && x / 2 < -1) {
                b = sin(pow(x, 2));
            } else {
                System.out.printf("При x/2=%.2f вычисления не определены%n", x / 2);
            }
            if (b != 0) {
                System.out.printf("При x/2=%.2f a=%f%n", x / 2, log10(abs(b + 2.74)));
            }
        }
    }

    private static void step1() {
        double sum = 0;
        for (double a =0; a<=2;a+=0.2){
            for (int x = 1; x < 7; x++) {
                sum += (pow(7,a) - cos(x));
                System.out.printf("При a=%f Сумма y = %f\n",a,sum);
            }
        }
    }
}
