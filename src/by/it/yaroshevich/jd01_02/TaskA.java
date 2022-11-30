package by.it.yaroshevich.jd01_02;

import java.util.Arrays;
import java.util.Scanner;

public class TaskA {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int [] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        step1(arr);
        step2(arr);
        step3(arr);
    }
    public static void step1(int[] arr){
        int min = arr[0];
        int max = arr[9];
        for (int value : arr){
            if (min>value){
                min=value;
            }
            if (max<value){
                max=value;
            }
        }
        System.out.println(min + " " + max);
    }
    public static void step2(int [] arr){
        double sum = 0;
        for (int element : arr){
            sum = sum + element;
        }
        double avg = sum/arr.length;
        for (int element : arr){
            if (element < avg){
                System.out.print(element + " ");
            }
        }
    }
    public static void step3 (int [] arr){
        int min=arr[0];
        for (int value : arr) {
            if (min>value){
                min=value;
            }
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == min){
                System.out.print(i + " ");
            }
        }
        System.out.println();
            }
        }
