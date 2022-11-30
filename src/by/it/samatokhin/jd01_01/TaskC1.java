package by.it.samatokhin.jd01_01;

/* Нужно написать программу, которая вводит два числа с клавиатуры
и выводит их сумму на экран в виде

Ввод (это вы вводите с клавиатуры):
34 26

Вывод (это должно появиться в консоли, обратите внимание на пробелы и слово Sum:
Sum = 60

*/

import java.util.Scanner;

class TaskC1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        int a = sc.nextInt();
        System.out.println();
        int b = sc.nextInt();
        System.out.println("Sum = "+(a+b));
    }
}
