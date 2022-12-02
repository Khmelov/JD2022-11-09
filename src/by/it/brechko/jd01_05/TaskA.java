package by.it.brechko.jd01_05;

import static java.lang.Math.*;

public class TaskA {
    public static void main(String[] args) {
        step1();
    }

    private static void step1() {
        final double a=756.13;
        final double x=0.3;
        double part1 = cos(pow(pow(x, 2) + PI / 6, 5));
        double part2=sqrt(x*pow(a,3));
        double part3 = log(abs((a - 1.12 * x) / 4));
        double z=part1-part2-part3;
        System.out.printf("При x=%f a=%f z=%fn",x,a,z);
    }
}

