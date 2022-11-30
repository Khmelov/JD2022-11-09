package by.it.vasileuskaya.jd01_02;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размерность квадратной матрицы:");
        int n = scanner.nextInt();
        step1(n);
        step2(step1(n));
    }

    private static int[][] step1(int n) {
        int[][] arr = new int[n][n];
        do {
            createArray(arr, n);
        } while (!arrayContainsValue(arr, n) || !arrayContainsValue(arr, -n));
        printArray(arr);
        return arr;
    }

    static void createArray(int[][] arr, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = (int) (Math.random() * ((2 * n) + 1)) - n;
            }
        }
    }

    static boolean arrayContainsValue(int[][] arr, int n) {
        boolean check = false;
        for (int[] value : arr) {
            for (int value2 : value) {
                if (value2 == n) {
                    check = true;
                    break;
                }
            }
        }
        return check;
    }

    static void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int step2(int[][] arr) {
        System.out.println("Array for step2");
        printArray(arr);

        int sumElements = 0;
        for (int i = 0; i < arr.length; i++) {
            int indexFirst = -1;
            int indexLast = -1;
            int sumElementsOneRow = 0;
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] >= 0) {
                    if (indexFirst < 0) {
                        indexFirst = j;
                    } else {
                        indexLast = j;
                        break;
                    }
                }
            }
            if (indexLast - indexFirst > 1) {
                for (int k = indexFirst + 1; k < indexLast; k++) {
                    sumElementsOneRow += arr[i][k];
                }
            } else {
                sumElementsOneRow = 0;
            }
            sumElements += sumElementsOneRow;
        }
        System.out.println(sumElements);
        return sumElements;
    }
}



