package by.it.han.jd01_05;

import static java.lang.Math.*;

public class TaskA {

    public static final double A = 756.13;
    public static final double X = 0.3;

    public static void main(String[] args) {
        System.out.println(getResultOneExpression(A, X));
        System.out.println(getResultManyExpression(A, X));
    }

    public static double getResultOneExpression(double a, double x) {
        return cos(pow((pow(x, 2) + (PI / 6)), 5)) - Math.sqrt(x * pow(a, 3)) - log(abs((a - 1.12 * x) / 4));
    }

    public static double getResultManyExpression(double a, double x) {
        double firstPart = cos(pow((pow(x, 2) + (PI / 6)), 5));
        double secondPart = Math.sqrt(x * pow(a, 3));
        double thirdPart = log(abs((a - 1.12 * x) / 4));
        return firstPart - secondPart - thirdPart;
    }
}
