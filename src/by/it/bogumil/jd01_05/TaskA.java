package by.it.bogumil.jd01_05;

import static java.lang.Math.*;

public class TaskA {
    public static void main(String[] args) {
        step1();
        step2();
        step3();
    }

    public static void step1() {

        double a = 756.13;
        double x = 0.3;

        System.out.println(getExpression(a, x));
        System.out.println(getManyExpression(a, x));
    }

    public static double getExpression(double a, double x) {
        return cos(pow((pow(x, 2) + (PI / 6)), 5)) - Math.sqrt(x * pow(a, 3)) - log(abs((a - 1.12 * x) / 4));
    }

    public static double getManyExpression(double a, double x) {
        double firstPart = cos(pow((pow(x, 2) + (PI / 6)), 5));
        double secondPart = Math.sqrt(x * pow(a, 3));
        double thirdPart = log(abs((a - 1.12 * x) / 4));
        return firstPart - secondPart - thirdPart;
    }

    public static void step2() {
        double a = 1.21;
        double b = 0.371;
        double result = tan(pow((a + b), 2)) - pow(a + 1.5, 1.0 / 3) + a * pow(b, 5) - b / log(pow(a, 2));
        System.out.println(result);
    }

    public static void step3() {
        double x = 12.1;
        double deltaA = 3.75;
        System.out.println("x:" + x);
        for (double a = -5; a <= 12; a += deltaA) {
            double f = exp(a * x) - 3.45 * a;
            System.out.println("a:" + a + ", f:" + f);
        }
    }
}

