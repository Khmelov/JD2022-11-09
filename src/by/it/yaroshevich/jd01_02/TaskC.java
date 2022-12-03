package by.it.yaroshevich.jd01_02;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class TaskC {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] array = step1(n);
    }

    public static int[ ][ ] step1(int n) {
        int[][] array = new int[n][n];
        boolean isMin = false;
        boolean isMax = false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int randomNumber = ThreadLocalRandom.current().nextInt(-n, n+1);
                array[i][j] = randomNumber;

                if (randomNumber == -n) {
                    isMin = true;
                }

                if (randomNumber == n) {
                    isMax = true;
                }
            }

        }

        if (isMin && isMax) {
            print2D(array);
        }
        else {
            return step1(n);
        }

        return array;
    }

    private static void print2D(int array[][])
    {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}
