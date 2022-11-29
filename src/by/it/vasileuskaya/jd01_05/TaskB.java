package by.it.vasileuskaya.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        part1();
        part2();
    }

    static void part1() {
        double y = 0;
        for (double a = 0; a <= 2; a += 0.2) {
            for (int x = 1; x < 7; x++) {
                y += pow(7, a) - cos(x);
            }
            System.out.printf("a=%3.2f => y=%-10.5f%n", a, y);
        }
    }

    static void part2() {
        double b = 0;
        for (double x = -5.5; x < 2; x += 0.5) {
            if (x / 2 > -2 & x / 2 <= -1) {
                b = sin(x * x);
            }
            if (x / 2 > -1 & x / 2 < 0.2) {
                b = cos(x * x);
            }
            if (x / 2 == 0.2) {
                b = cos(x * x) / sin(x * x);
            }
            double a = log10(abs(b + 2.74));
            System.out.println((x / 2) + "=> " + a);
        }
    }
}

