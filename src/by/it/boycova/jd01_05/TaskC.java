package by.it.boycova.jd01_05;

import static java.lang.Math.cbrt;
import static java.lang.Math.pow;

public class TaskC {
    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step2() {

    }

    private static void step1() {
        double [] A =new double[30];
        double x=5.33;
        for (int i = 0; i < A.length; i++) {
            double z = cbrt(pow(x, 2) + 4.5);
            A[i] = z;
            x = x + 0.12;
            System.out.print("A[" + i + "]=" + A[i] + "    ");
            if (i % 5 ==0) {
                System.out.println();
            }
        }



        int counter=0;
        for (int i = 0; i < A.length; i++) {
            if(A[i]>3.5){
                counter=counter+1;
            }
        }
        double[] B= new double[counter];
        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if(A[j]>3.5){
                    B[i]=A[i];
                }
            }
        }
        double multi=1;
        for (int i = 0; i < B.length; i++) {
            multi=multi*B[i];
        }
        double avr=pow(multi,1/counter);
    }
}
