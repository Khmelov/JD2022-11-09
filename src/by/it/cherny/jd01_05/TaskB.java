package by.it.cherny.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step2() {
        double b = 0;
        double a = 0;
        for (double x = -5.5; x < 2; x+=0.5) {
            double halfX = x/2.0;
            if ((halfX> -2) && (halfX<=-1)){
                b = sin(x*x);
                a = log(abs(b+2.74));
            System.out.printf("При x=%.4f a=%f\n",halfX,a);
            } else if ((halfX>-1)&&(halfX<0.2)) {
                b = cos(x*x);
                a = log(abs(b+2.74));
            System.out.printf("При x=%.4f a=%f\n",halfX,a);
            } else if (halfX==0.2) {
                b = atan(x*x);
                a = log(abs(b+2.74));
            System.out.printf("При x=%.4f a=%f\n",halfX,a);
            } else {
                System.out.printf("При x=%.4f Невозможно вычислить\n",halfX);
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
