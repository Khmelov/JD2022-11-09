package by.it.cherny.jd01_02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = step1(n);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(step2(arr));
        int[][] arr3 = step3(arr);
        for (int i = 0; i < arr3.length; i++) {
            for (int j = 0; j < arr3[i].length; j++) {
                System.out.print(arr3[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] step3(int[][] arr) {
        int max = 0;
        // find max
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (max<arr[i][j]){
                    max=arr[i][j];
                }
            }
        }
        //find rows and cols
        int k = 0;
        ArrayList<Integer> rows = new ArrayList<Integer>();
        ArrayList<Integer> column = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j]==max) {
                    if (!rows.contains(i)){
                        System.out.println(i+"iii");
                        rows.add(i);
                    }
                    if (!column.contains(j)){
                        column.add(j);
                        System.out.println(i+"jjj");
                    }
                    k++;
                }
            }
        }
        // create new arr
        int[][] newArr = new int[arr.length- rows.size()][arr.length- column.size()];
        int newArrI = 0;
        int newArrJ = 0;
        for (int i = 0; i < arr.length; i++) {
            if(!rows.contains(i)) {
                newArrJ = 0;
                for (int j = 0; j < arr.length; j++) {
                    if(!column.contains(j)) {
                        newArr[newArrI][newArrJ] = arr[i][j];
                        newArrJ++;
                    }
                }
                newArrI++;
            }
        }

        return newArr;
    }

    private static int step2(int[][] arr) {
        int sum = 0;
        int k = 0;
        int arrIndex[] = new int[2];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j]>0 && k<2){
                    arrIndex[k]=j;
                    k++;
                }
            }
            if (k!=0 && k!=1 && arrIndex[1]-arrIndex[0]-1!=0){
                for (int j = arrIndex[0]+1; j < arrIndex[1]; j++) {
                    sum+=arr[i][j];
                }
            }
            arrIndex[1]=0;
            arrIndex[0]=0;
            k=0;
            System.out.println();
        }
        return sum;
    }

    private static int[][] step1(int n){
        int[][] arr = new int[n][n];
        boolean isMade = false;
        boolean[] hasArr = new boolean[2];
        while (true){
            for (int i=0;i<arr.length;i++) {
                for (int j=0; j<arr[0].length;j++) {
                    int max = n;
                    int min = -n;
                    max -= min;
                    int rnd = (int) (Math.random() * ++max) + min;
                    arr[i][j]=rnd;
                    if (arr[i][j]==n){
                        hasArr[0]=true;
                    }
                    if (arr[i][j]==-n){
                        hasArr[1]=true;
                    }
                    if (hasArr[0] && hasArr[1] && isMade) {
                        return arr;
                    }
                }
                if (i == arr.length-1){
                    isMade = true;
                }
            }
        }
    };
}
