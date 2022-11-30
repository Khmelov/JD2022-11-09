package by.it.khmelov.jd01_02;


import java.util.Locale;
import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        step1(arr);
        step2(arr);
        step3(arr);
    }

    private static void step1(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        for (int value : arr) {
            if (min > value) {
                min = value;
            }
            if (max < value) {
                max = value;
            }
        }
        System.out.println(min + " " + max);
    }

    private static void step2(int[] arr) {
        double sum = 0;
        for (int element : arr) {
            sum += element;
        }
        double avg = sum / arr.length;
        System.out.printf("avg=%f%n", avg);
        for (int element : arr) {
            if (element < avg) {
                System.out.print(element + " ");
            }
        }
        System.out.println();
    }

    private static void step3(int[] arr) {
        int min = arr[0];
        for (int value : arr) {
            if (min > value) {
                min = value;
            }
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == min) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }


}
