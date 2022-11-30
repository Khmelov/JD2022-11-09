package by.it.han.jd01_04;

import java.util.Scanner;

public class TaskB {
    private static final int COUNT_QUARTER = 4;
    private static final String SEPARATOR = "--------------------------------------------------";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество фамилий");
        int countPeople = scanner.nextInt();
        System.out.println("Введите фамилии");
        String[] surnames = getSurnamesArr(scanner, countPeople);
        int[][] salaries = getSalariesArr(scanner, surnames);
        printTableSalary(countPeople, surnames, salaries);
    }

    private static void printTableSalary(int countPeople, String[] surnames, int[][] salaries) {
        System.out.println(SEPARATOR);
        System.out.printf("%-8s %-8s %-8s %-8s %-8s %-8s%n", "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
        System.out.println(SEPARATOR);
        int resultSum = 0;
        double countSalary = countPeople * COUNT_QUARTER;
        for (int i = 0; i < surnames.length; i++) {
            int sum = 0;
            System.out.printf("%8s: ", surnames[i]);
            for (int j = 0; j < salaries[i].length; j++) {
                sum += salaries[i][j];
                System.out.printf("%-8d ", salaries[i][j]);
            }
            System.out.printf("%-8d%n", sum);
            resultSum += sum;
        }
        System.out.println(SEPARATOR);
        System.out.printf("%-8s %-8d%n", "Итого", resultSum);
        System.out.printf("%-8s %-8f%n", "Средняя", resultSum / countSalary);
    }

    private static int[][] getSalariesArr(Scanner scanner, String[] surnames) {
        int[][] salaries = new int[surnames.length][COUNT_QUARTER];
        for (int i = 0; i < surnames.length; i++) {
            System.out.println("Введите зарплату для " + surnames[i]);
            for (int j = 0; j < COUNT_QUARTER; j++) {
                salaries[i][j] = scanner.nextInt();
            }
        }
        return salaries;
    }

    private static String[] getSurnamesArr(Scanner scanner, int countPeople) {
        String[] surnames = new String[countPeople];
        for (int i = 0; i < surnames.length; i++) {
            String inputSurnames = scanner.next();
            surnames[i] = inputSurnames;
        }
        return surnames;
    }
}
