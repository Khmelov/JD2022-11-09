package by.it.boycova.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step4();
        step5();
    }

    private static void step4() {
        double a;
        double x;
        double s = 0;
        double y = 0;
        for ( a = 0; a <=2 ; a= a + 0.2) {
            for ( x = 1; x<7; x ++) {
                s=pow(7,a)-cos(x);
                y=y+s;
            }
            System.out.println(y);
        }

    }

    private static void step5() {
        double b = 0;
        double a;
        for (double x = -5.5; x < 2; x+=0.5) {

            if(-2<x/2 && x/2<=-1){
                b=sin(pow(x,2));
            }
            else if(-1<x/2 && x/2<0.2 ){
                b=cos(pow(x,2));
            }
            else if( x/2==0.2 ) {
                b =1/tan(pow(x,2));
            }
            else {
                System.out.println("При x/2 ="+x/2+" вычисления не определены");
            }
            a = log10(abs(b+2.74));
            System.out.println("При x/2="+x+" a="+a);
        }
    }
}
