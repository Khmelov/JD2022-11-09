package by.it.boycova.jd01_05;

import static java.lang.Math.*;

public class TaskA {
    public static void main(String[] args) {
        step1();
        step2();
        step3();

    }

    private static void step3() {
        final double x=12.1;
        for (double a= -5; a<=12 ; a+=3.75) {
            double f=exp(a*x)-3.45*a;
            System.out.printf("При x=%4.1f a=%-5.2f f=%-10.5f",x,a,f);
            System.out.println();

        }

    }

    private static void step2() {
        final double a=1.21;
        final double b=0.371;
        double y = tan(pow(a+b,2))-cbrt(a+1.5)+a*pow(b,5)-b/log(pow(a,2));
        System.out.printf("При a=%f b=%f y=%f", a,b,y);
        System.out.println();
    }

    private static void step1() {
        final double a=756.13;
        final double x=0.3;
        double part1 = cos(pow(pow(x, 2) + PI / 6, 5));
        double part2= sqrt(x*pow(a,3));
        double part3=log(abs((a-1.12*x)/4));
        double z= part1-part2-part3;
        System.out.printf("При x=%f a=%f z=%f",x,a,z);
        System.out.println();

    }
}
