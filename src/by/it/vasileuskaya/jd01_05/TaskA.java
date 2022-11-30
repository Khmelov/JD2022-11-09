package by.it.vasileuskaya.jd01_05;

import static java.lang.Math.*;

public class TaskA {
    public static void main(String[] args) {
        part1();
        part2();
        part3();
    }

    private static void part1() {
        double a = 756.13;
        double x = 0.3;
        double step1 = cos(pow(pow(x, 2) + PI / 6, 5));
        double step2 = sqrt(x * pow(a, 3));
        double step3 = log(abs((a - 1.12 * x) / 4));
        double z = step1 - step2 - step3;
        System.out.println(z);
    }

    private static void part2() {
        double a = 1.21;
        double b = 0.371;
        double step1 = tan(pow(a + b, 2));
        double step2 = cbrt(a + 1.5);
        double step3 = a * pow(b, 5);
        double step4 = b / (log(a * a));
        double y = step1 - step2 + step3 - step4;
        System.out.println(y);
    }

    private static void part3() {
        double x = 12.1;
        for (double a = -5; a <= 12; a += 3.75) {
            double f = exp(a * x) - 3.45 * a;
            System.out.printf("x=%4.2f, a=%4.2f => f=%ef%n", x, a, f);
        }
    }
}
