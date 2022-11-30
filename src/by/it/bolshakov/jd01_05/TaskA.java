package by.it.bolshakov.jd01_05;

import static java.lang.Math.*;

public class TaskA {

    private static void task1() {
        final double X = 0.3;
        final double A = 756.13;
        double z = cos(pow((X*X+PI/6),5));
        z = z-sqrt(X*pow(A,3));
        z= z-log(abs((A-1.12*X)/4));
        System.out.println("z="+z);
        System.out.println("z=" + (cos(pow((X*X+PI/6),5)) - sqrt(X*pow(A,3)) - log(abs((A-1.12*X)/4))));
    }

    private static void task2() {
        final double A = 1.21;
        final double B = 0.371;
        double y = tan(pow(A+B,2)) - cbrt(A+1.5) + A*pow(B,5) - B/log(A*A);
        System.out.println("y=" + y);
    }

    private static void task3() {
        final double X = 12.1;
        for (double a = -5; a <= 12 ; a+=3.75) {
            double f = exp(a*X)-3.45*a;
            System.out.printf("При a=%6.2f f=%g\n",a,f);
        }
    }


    public static void main(String[] args) {
        task1();
        task2();
        task3();
    }
}
