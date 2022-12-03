package by.it.StringDemo;
/* 3. Ввести n строк с консоли. Вывести на консоль те строки, длина которых меньше (больше)
средней длинны, а также длину.*/

import java.util.Arrays;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {

        int sred = 0, minimal = 0, lonJ = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("введите число строк: ");
        int n = sc.nextInt();
        String[] array = new String[n];
        double b = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.next();
            b = array[i].length();
        }
        b = b / n;
        for (int i = 0; i < array.length; i++) {
            if (array[i].length() < b) {
                System.out.println(array[i] + " length" + array.length);
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
