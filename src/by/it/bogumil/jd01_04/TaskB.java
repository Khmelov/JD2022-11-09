package by.it.bogumil.jd01_04;
/*Создайте в пакете by.it.familiya.jd01_04 класс TaskB и напишите в нем код, со
следующей логикой (можно все прямо в main):
B1. Введите с консоли число людей n (nextInt() в сканере).
 Затем введите одномерный массив их фамилий (next() в сканере).
 Введите двумерный массив их зарплат за 4 квартала (N строк и 4 столбца).
 Зарплаты имеют тип int.
 Нужно для каждой фамилии выводить подсказку
 После подсказки можно через пробел вводить с консоли 4 цифры зарплат по кварталам (nextInt() в
сканере).

 Постройте в консоли таблицу доходов людей по кварталам с фамилиями и
итогом за год в последней колонке.
B2. Посчитайте и выведите общую сумму всех выплат и среднеарифметическую
квартальную зарплату с точностью как минимум до 4-го знака */

import java.util.Scanner;

public class TaskB {

    private static final int COUNT_QUARTER = 4;
    private static final String SEPARATOR = "-";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите число: ");
        int countPeople = scanner.nextInt();

        System.out.println("Введите " + countPeople + " фамилий");

        String[] surnames = getSurnamesArr(scanner, countPeople);
        int[][] salaries = getSalariesArr(scanner, surnames);
        printTableSalary(countPeople, surnames, salaries);
    }

    private static void printTableSalary(int countPeople, String[] surnames, int[][] salaries) {

        System.out.println(SEPARATOR);
        System.out.printf("%-8s %-8s %-8s %-8s %-8s %-8s%n",
                "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
        System.out.println(SEPARATOR);

        int result = 0;
        double countSalary = countPeople * COUNT_QUARTER;
        for (int i = 0; i < surnames.length; i++) {
            int sum = 0;
            System.out.printf("%8s: ", surnames[i]);
            for (int j = 0; j < salaries[i].length; j++) {
                sum += salaries[i][j];
                System.out.printf("%-8d ", salaries[i][j]);
            }
            System.out.printf("%-8d%n", sum);
            result += sum;
        }
        System.out.println(SEPARATOR);
        System.out.printf("%-8s %-8d%n", "Итого", result);
        System.out.printf("%-8s %-8f%n", "Средняя", result / countSalary);
    }

    private static int[][] getSalariesArr(Scanner scanner, String[] surnames) {
        int[][] arrays = new int[surnames.length][COUNT_QUARTER];
        for (int i = 0; i < surnames.length; i++) {

            System.out.println("Введите зарплату для " + surnames[i]);

            for (int j = 0; j < COUNT_QUARTER; j++) {
                arrays[i][j] = scanner.nextInt();
            }
        }
        return arrays;
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

