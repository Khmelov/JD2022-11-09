package by.it.han.jd01_02;

import java.util.Arrays;
import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
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
        System.out.println(Arrays.stream(arr).min().orElse(arr[0]) + " " + Arrays.stream(arr).max().orElse(arr[0]));
    }

    private static void step2(int[] arr) {
        double avg = Arrays.stream(arr).average().orElse(arr[0]);
        Arrays.stream(arr).filter(i -> i < avg).forEach(s -> System.out.print(s + " "));
    }

    private static void step3(int[] arr) {
        int min = Arrays.stream(arr).min().orElse(arr[0]);
        for (int i = arr.length - 1; i >= 0; i--) {
            if (min == arr[i]) {
                System.out.print(i + " ");
            }
        }
    }
}
