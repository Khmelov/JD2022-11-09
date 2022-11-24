package by.it.cherny.jd01_02;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=sc.nextInt();
        }
        step1(arr);
        step2(arr);
        step3(arr);
    }

    private static void step1(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        for (int i : arr) {
            if (i<min){
                min=i;
            }
            if (i>max){
                max=i;
            }
        }
        System.out.println(min+" "+max);
    }
    private static void step2(int[] arr) {
        double sum = 0;
        for (int i : arr) {
            sum+=i;
        }
        double avg = sum/arr.length;
        for (int i : arr) {
            if (i<avg) {
                System.out.print(i+ " ");
            }
        }
        System.out.println();
    }
    private static void step3(int[] arr) {
        int min = arr[0];
        for (int i : arr) {
            if (i<min){
                min=i;
            }
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i]==min){
                System.out.print(i+" ");
            }
        }
        System.out.println();
    }
}
