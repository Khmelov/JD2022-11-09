package by.it.yaroshevich.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

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
        String [] [] arrayMerg = new String [arraySalaries.length] [arraySurname.length];
        for (int i = 0; i < arraySalaries.length; i++) {
            for (int j = 0; j < arraySurname.length; j++) {
                System.out.println(arrayMerg[i][j]);

            }

        }
    }
}

