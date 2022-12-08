package by.it.boycova.jd01_02;

import java.util.Random;
import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) {
        Scanner scanner= new Scanner (System.in);
        int n= scanner.nextInt();
        int[][]array= new int [n][n];
        step1(n);
        step2 (array);
        step3(array);

    }




    static int[][] step1(int n){
        Random generator=new Random();
        int[][]array= new int [n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = generator.nextInt(n * 2 + 1) - n;
            }
        }
        return (array);
    }
     static int step2(int[][] array) {

             int com_summa=0;
        for (int[] ints : array) {
            int counter = 0;
            int summa = 0;
            for (int anInt : ints) {
                if (anInt > 0) {
                    counter = counter + 1;
                }
                if (counter == 2) {
                    com_summa = com_summa + summa;
                    break;
                }
                if (anInt < 0 && counter == 1) {
                    summa = summa + anInt;
                }
            }
        }
        return  com_summa;
    }
     static int [][] step3(int[][] array) {
        int max=Integer.MIN_VALUE;
        for (int[] line : array) {
            for (int element : line) {
                if(max<element){
                    max=element;
                }
            }
        }
        boolean [] delLines=new boolean[array.length];
        boolean [] delColums=new boolean[array.length];
         for (int i = 0; i < array.length; i++) {
             for (int j = 0; j < array[i].length; j++) {
                 if(array[i][j]==max){
                     delLines[i]=true;
                     delColums[j]=true;
                 }
             }
         }
         int row=0;
         for(boolean del : delLines){
             if (!del){
                 row++;
             }
         }
         int col=0;
         for(boolean del : delColums){
             if (!del){
                 col++;
             }
         }
         int[][]result_array= new int[row][col];
         for (int i = 0, ir=0; i < array.length; i++) {
             if(!delLines[i]){
                 for (int j = 0, jr=0; j < array[i].length; j++) {
                     if(!delColums[j]){
                         result_array[ir][jr++]=array[i][j];
                     }
                 }
                 ir++;
             }
         }
         return result_array;
    }
}

