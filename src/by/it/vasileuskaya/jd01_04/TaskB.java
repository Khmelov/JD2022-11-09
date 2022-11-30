package by.it.vasileuskaya.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите количество работников:");
        int n = scan.nextInt();
        System.out.println("Введите фамилии работников:");
        String[] arrayOfSurnames = new String[n];
        for (int i = 0; i < arrayOfSurnames.length; i++) {
            arrayOfSurnames[i] = scan.next();
        }
        int[][] salary = new int[n][4];
        int[] salaryForYear = new int[n];
        int sumSalary = 0;
        for (int i = 0; i < n; i++) {
            System.out.println("Введите зарплату для " + arrayOfSurnames[i] + ": ");
            for (int j = 0; j < 4; j++) {
                salary[i][j] = scan.nextInt();
                salaryForYear[i] += salary[i][j];
            }
            sumSalary += salaryForYear[i];
        }
        double averageSalary = 1.0 * sumSalary / (n * 4);
        printTable(arrayOfSurnames, salary, salaryForYear, sumSalary, averageSalary);
    }

    private static void printTable(String[] arrayOfSurnames, int[][] salary, int[] salaryForYear, int sumSalary, double averageSalary) {
        System.out.println("------------------------------------------------------------");
        System.out.printf("%-9s%-11s%-11s%-11s%-11s%-5s%n", "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
        System.out.println("------------------------------------------------------------");
        for (int i = 0; i < arrayOfSurnames.length; i++) {
            System.out.printf("%7s%-2s", arrayOfSurnames[i], ":");
            for (int j = 0; j < salary[i].length; j++) {
                System.out.printf("%-11d", salary[i][j]);
            }
            System.out.printf("%-5d%n", salaryForYear[i]);
            System.out.println();
        }
        System.out.println("------------------------------------------------------------");
        System.out.printf("%-11s%-5d%n%-11s%-9.4f", "Итого", sumSalary, "Средняя", averageSalary);
    }
}
