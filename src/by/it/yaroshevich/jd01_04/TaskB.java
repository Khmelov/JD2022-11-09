package by.it.yaroshevich.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum=0;
        double fullSum = 0;
        double averageSum = 0;
        String[] arraySurname = new String[n];

        for (int i = 0; i < arraySurname.length; i++) {
            arraySurname[i] = sc.next();
        }

        int[][] arraySalaries = new int[n][4];
        for (int i = 0; i < arraySalaries.length; i++) {
            System.out.println("Введите зарплату для " + arraySurname[i]);
            for (int j = 0; j < 4; j++) {
                arraySalaries[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < arraySurname.length; i++) {
            System.out.print(arraySurname[i] + " ");

                for (int j = 0; j < arraySalaries[i].length; j++) {
                    System.out.print(arraySalaries[i][j] + " ");
                    }
            while(sum<arraySalaries[i].length){
                for (int j = 0; j < arraySalaries[i].length; j++) {
                    sum = sum + arraySalaries[i][j];
                }
            }
            System.out.print(sum);
            sum=0;
            System.out.println();
        }
        for (int i = 0; i < arraySalaries.length; i++) {
            for (int j = 0; j < arraySalaries[i].length; j++) {
                fullSum+=arraySalaries[i][j];
                averageSum = fullSum/arraySalaries[i][j];
            }
        }
        System.out.println("Итого " + fullSum);
        System.out.printf("%6.4f", averageSum);


    }
}

