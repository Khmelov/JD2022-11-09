package by.it.cherny.jd01_02;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        step1();
        int month = sc.nextInt();
        step2(month);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        step3(a,b,c);
    }

    private static void step3(double a, double b, double c) {
        double d = b*b-4*a*c;
        if (d<0) {
            System.out.println("корней нет");
        }
        else if (d==0) {
            double x=(-b)/(2*a);
            System.out.println(x);
        }
        else {
            double x1 = (-b+Math.sqrt(d))/(2*a);
            double x2 = (-b-Math.sqrt(d))/(2*a);
            System.out.println(x1+" "+x2);
        }
    }

    private static void step2(int month) {
        switch (month) {
            case 1:
                System.out.println("январь");
                break;
            case 2:
                System.out.println("февраль");
                break;
            case 3:
                System.out.println("март");
                break;
            case 4:
                System.out.println("апрель");
                break;
            case 5:
                System.out.println("май");
                break;
            case 6:
                System.out.println("июнь");
                break;
            case 7:
                System.out.println("июль");
                break;
            case 8:
                System.out.println("август");
                break;
            case 9:
                System.out.println("сентябрь");
                break;
            case 10:
                System.out.println("октябрь");
                break;
            case 11:
                System.out.println("ноябрь");
                break;
            case 12:
                System.out.println("декабрь");
                break;
            default:
                System.out.println("нет такого месяца");
                break;
        }
    }

    private static void step1() {
        int[][] arr = new int[5][5];
        for (int i = 0; i< arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = i*5+1+j;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
};

