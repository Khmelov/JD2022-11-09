package by.it.StringDemo;
/* 2. Ввести n строк с консоли. Упорядочить и вывести строки в порядке возрастания (убывания)
значений их длины.*/

import java.util.Arrays;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число строк: ");
        int n = sc.nextInt();

        System.out.println("введите " + n + " строк");
        String[] array = new String[n];
        array[0] = sc.nextLine();

        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextLine();
        }
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {

                if (array[j].length() > array[j + 1].length()) {
                    String tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}


