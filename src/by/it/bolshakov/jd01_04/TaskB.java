package by.it.bolshakov.jd01_04;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class TaskB {

    public static void print2DArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.printf("a[%d][%d]=%-3d", i, j, array[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        final int NUMBER_OF_QUARTERS = 4;
        String[] names = new String[n];
        for (int i = 0; i < n; i++) {
            names[i] = scanner.next();
        }
        int[][] salary = new int[n][NUMBER_OF_QUARTERS];
        for (int i = 0; i < n; i++) {
            System.out.println("Введите зарплату для " + names[i]);
            for (int j = 0; j < NUMBER_OF_QUARTERS; j++) {
                salary[i][j] = scanner.nextInt();
            }
        }
        int sum = 0;
        System.out.println("-----------------------------------------------------------------");
        System.out.printf("%-10s %-15s%-15s%-15s%-15s%-15s", "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
        System.out.println();
        System.out.println("-----------------------------------------------------------------");
        for (int i = 0; i < n; i++) {
            System.out.printf("%10s: ", names[i]);
            for (int j = 0; j < NUMBER_OF_QUARTERS; j++) {
                System.out.printf("%-15d", salary[i][j]);
            }
            sum+=salary[i][0] + salary[i][1] + salary[i][2] + salary[i][3];
            System.out.printf("%-15d", salary[i][0] + salary[i][1] + salary[i][2] + salary[i][3]);
            System.out.println();
        }
        System.out.println("-----------------------------------------------------------------");
        System.out.printf("Итого %-15d", sum);
        System.out.println();
        System.out.printf("Средняя %-15.4f", 1.0*sum/n/4/1.0);
    }
}
