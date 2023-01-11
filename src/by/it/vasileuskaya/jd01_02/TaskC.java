package by.it.vasileuskaya.jd01_02;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размерность квадратной матрицы:");
        int n = scanner.nextInt();
        int[][] arr = step1(n);
        step2(arr);
        int[][] ints = step3(arr);
        System.out.println("Array for step3");
        printArray(ints);
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

    static int[][] step3(int[][] arr) {
        int max = findMax(arr);
        boolean[] delRow = new boolean[arr.length];
        boolean[] delCol = new boolean[arr[0].length];
        fillDelArray(arr, max, delRow, delCol);
        int rows = getFalseCount(delRow);
        int cols = getFalseCount(delCol);
        return createResult(arr, delRow, delCol, rows, cols);

    }

    private static int findMax(int[][] array) {
        int max = Integer.MIN_VALUE;
        for (int[] row : array) {
            for (int element : row) {
                if (max < element) {
                    max = element;
                }
            }
        }
        return max;
    }

    private static void fillDelArray(int[][] array, int max, boolean[] delRow, boolean[] delCol) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == max) {
                    delRow[i] = true;
                    delCol[j] = true;
                }
            }
        }
    }

    private static int getFalseCount(boolean[] delRow) {
        int rows = 0;
        for (boolean del : delRow) {
            if (!del) {
                rows++;
            }
        }
        return rows;
    }

    private static int[][] createResult(int[][] array, boolean[] delRow, boolean[] delCol, int rows, int cols) {
        int[][] result = new int[rows][cols];
        for (int i = 0, ires = 0; i < array.length; i++) {
            if (!delRow[i]) {
                for (int j = 0, jres = 0; j < array[i].length; j++) {
                    if (!delCol[j]) {
                        result[ires][jres++] = array[i][j];
                    }
                }
                ires++;
            }
        }
        return result;
    }
}



