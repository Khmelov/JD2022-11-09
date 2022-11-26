package by.it.boycova.jd01_02;


import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int[] arr = new int [10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
      step1(arr);
      step2(arr);
      step3(arr);
    }

    public static void step1(int[] arr){
        int min = arr[0];
        int max = arr[0];

        for (int j : arr) {
            if (min > j) {
                min = j;
            }
        }
        for (int j : arr) {
            if (max < j) {
                max = j;
            }
        }
        System.out.println(min+" "+ max);
    }

    private static void step2(int[] arr) {
        double sum=0;
        for (int i : arr) {
           sum=sum+i;
        }
        double avr=sum/ arr.length;
        for (int i : arr) {
            if( i < avr){
                System.out.print(i+" ");
            }

        }
        System.out.println();
    }

    private static void step3(int[] arr) {
        int min = arr[0];

        for (int j : arr) {
            if (min > j) {
                min = j;
            }
        }
            for (int i = arr.length - 1; i >= 0; i--) {
                if(arr[i]==min){
                    System.out.print(i+" ");
                }
            }
    }
}
