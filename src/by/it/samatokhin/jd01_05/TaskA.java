package by.it.samatokhin.jd01_05;

import static java.lang.Math.*;

public class TaskA {
    public static void main(String[] args) {
        step1();
        step2();
        step3();
    }

    private static void step1() {
        final double a=756.13;
        final double x= 0.3;
        double part1 = cos(pow(pow(x, 2) + PI / 6, 5));
        double part2 = sqrt(x*pow(a,3));
        double part3 = log(abs((a - 1.12 * x) / 4));
        double z=part1-part2-part3;
        System.out.printf("For x=%f a=%f z=%f%n",x,a,z);

    }

    private static void step2() {
        final double a=1.21;
        final double b= 0.371;
        double y= ((tan(pow(a + b, 2)) - pow(a + 1.5, 1.0 / 3)) + (a * pow(b, 5))) - (b / log(a * a));
        System.out.printf("For a=%f b=%f y=%f%n",a,b,y);
    }

    private static void step3() {
        final double x=12.1;
        for (double a = -5; a <=12; a+=3.75) {
            double f=exp(a*x)-3.45*a;
            System.out.printf("For x=%f5.2f a=%-10.5f f=%g%n",x,a,f);
            
        }
    }
}
