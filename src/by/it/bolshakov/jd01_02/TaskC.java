package by.it.bolshakov.jd01_02;

import java.util.Random;
import java.util.Scanner;

public class TaskC {

    static int[][] step1(int n) {
        Random random = new Random();
        int[][] arr = new int[n][n];
        boolean checkUpper = false;
        boolean checkLower = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = random.nextInt(-n, n+1);
                if (arr[i][j] == -n) {
                    checkLower = true;
                } else if (arr[i][j] == n) {
                    checkUpper = true;
                }
            }
        }

        if (checkUpper & checkLower) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            arr = step1(n);
        }
        return arr;
    }

    static int step2(int[ ][ ] arr) {
        int sum = 0;
        for (int j = 0; j < arr.length; j++) {
            int first = -1;
            int second = -1;
            for (int i = 0; i < arr[j].length; i++) {
                if (arr[j][i] > 0) {
                    if (first < 0) {
                        first = i;
                    } else if (second < 0) {
                        second = i;
                    }
                }
            }
            if (first != second) {
                for (int i = first + 1; i < second; i++) {
                    sum += arr[j][i];
                }
            }
        }
        return sum;
    }

    static int[ ][ ] step3(int[ ][ ] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] > max) {
                    max = arr[i][j];
                }
            }
        }
        int[] remove_col = new int[arr[0].length];
        int[] remove_row = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == max) {
                    remove_col[j] = 1;
                    remove_row[i] = 1;
                }
            }
        }

        int sum_col_rm = 0;
        int sum_row_rm = 0;

        for (int i = 0; i < remove_col.length; i++) {
            if (remove_col[i] == 1) {
                sum_col_rm+= 1;
            }
        }

        for (int i = 0; i < remove_row.length; i++) {
            if (remove_row[i] == 1) {
                sum_row_rm+= 1;
            }
        }

        int new_arr[][] = new int[arr.length - sum_row_rm][arr[0].length - sum_col_rm];
        int p = 0;
        for( int i = 0; i < arr.length; ++i)
        {
            if ( remove_row[i] == 1)
                continue;


            int q = 0;
            for( int j = 0; j < arr[0].length; ++j)
            {
                if ( remove_col[j] == 1)
                    continue;

                new_arr[p][q] = arr[i][j];
                ++q;
            }

            ++p;
        }
        for (int i = 0; i < new_arr.length; i++) {
            for (int j = 0; j < new_arr[0].length; j++) {
                System.out.print(new_arr[i][j] + " ");
            }
            System.out.println();
        }
        return new_arr;
    }


    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        step2(step1(n));
        int[][] m4 = {{1, -2, -2, 6}, {-1, 2, -2, 2}, {-2, -2, -6, -2}};
        step3(m4);
    }
}
