package by.it.bolshakov.jd01_02;

import java.util.Scanner;
import java.util.Arrays;

public class TaskA {

    static void step1(int[ ] arr) {
        int[] arr1 = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arr1);
        System.out.print(arr1[0]+ " " + arr1[arr1.length-1]);
        System.out.println();
    }

    static void step2(int[ ] arr) {
        double avg = 0;
        for (int i = 0; i < arr.length; i++) {
            avg += arr[i];
        }
        avg = avg/arr.length;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < avg) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }
    static void step3(int[ ] arr) {
        int[] arr1 = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arr1);
        for (int i = arr.length - 1; i >= 0 ; i--) {
            if (arr[i] == arr1[0]) {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        Scanner scanner=new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            arr[i] = scanner.nextInt();
        }
        step1(arr);
        step2(arr);
        step3(arr);
    }
}
