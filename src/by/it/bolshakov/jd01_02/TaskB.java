package by.it.bolshakov.jd01_02;

import java.util.Scanner;
import java.util.stream.IntStream;

public class TaskB {

    static void step1() {
        int[] arr = IntStream.rangeClosed(1, 25).toArray();
        int N = 5;
        for (int i = 0; i < arr.length; i++) {
            if (i % 5 == 0) {
                System.out.println();
            }
            System.out.print(arr[i] + " ");
        }
    };

    static void step2(int month) {
        switch (month) {
            case (1):
                System.out.println("январь");
                break;
            case (2):
                System.out.println("февраль");
                break;
            case (3):
                System.out.println("март");
                break;
            case (4):
                System.out.println("апрель");
                break;
            case (5):
                System.out.println("май");
                break;
            case (6):
                System.out.println("июнь");
                break;
            case (7):
                System.out.println("июль");
                break;
            case (8):
                System.out.println("август");
                break;
            case (9):
                System.out.println("сентябрь");
                break;
            case (10):
                System.out.println("октябрь");
                break;
            case (11):
                System.out.println("ноябрь");
                break;
            case (12):
                System.out.println("декабрь");
                break;
            default:
                System.out.println("нет такого месяца");
                break;
        }
    };

    static void step3(double a, double b, double c){
        double D = b*b - 4 * a * c;
        if (D > 0) {
            System.out.print((-b + Math.sqrt(D))/(2*a));
            System.out.print(" ");
            System.out.print((-b - Math.sqrt(D))/(2*a));
            System.out.println();
        } else if (D == 0) {
            System.out.println(-b/(2*a));
        } else {
            System.out.println("корней нет");
        }
    };

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int month = scanner.nextInt();
        step1();
        step2(month);
        double a = scanner.nextInt();
        double b = scanner.nextInt();
        double c = scanner.nextInt();
        step3(a ,b ,c);
    }
}
