package by.it.boycova.jd01_02;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        step1();
        int month= scanner.nextInt();
        step2(month);

        double a= scanner.nextDouble();
        double b= scanner.nextDouble();
        double c= scanner.nextDouble();
        step3(a, b, c);
    }

    private static void step1() {
        int j;
        for (j = 1; j < 26; j++) {
            if (j%5==0){
                System.out.print( j+ "\n");
            }
            else System.out.print( j + " ");

        }
    }
    private static  void step2(int month){
        switch (month) {
            case 1 -> System.out.println("январь");
            case 2 -> System.out.println("февраль");
            case 3 -> System.out.println("март");
            case 4 -> System.out.println("апрель");
            case 5 -> System.out.println("май");
            case 6 -> System.out.println("июнь");
            case 7 -> System.out.println("июль");
            case 8 -> System.out.println("август");
            case 9 -> System.out.println("сентябрь");
            case 10 -> System.out.println("октябрь");
            case 11 -> System.out.println("ноябрь");
            case 12 -> System.out.println("декабрь");
            default -> System.out.println("нет такого месяца");
        }
    }
    private static void step3(double a,double b,double c){
        double D= b*b-4*a*c;
        double x;
        if (D<0){
            System.out.println("корней нет");
        }
        else if (D==0){
            x=-(b/(2*a));
            System.out.println(x);
        }
        else {
            double x1=(-b+Math.sqrt(D))/(2*a);
            double x2=(-b-Math.sqrt(D))/(2*a);
            System.out.println(x1+" "+x2);
        }

    }
}
