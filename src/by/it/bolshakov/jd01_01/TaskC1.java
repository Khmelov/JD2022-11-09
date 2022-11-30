package by.it.bolshakov.jd01_01;

import java.util.Scanner;

/* Нужно написать программу, которая вводит два числа с клавиатуры
и выводит их сумму на экран в виде

Ввод (это вы вводите с клавиатуры):
34 26

Вывод (это должно появиться в консоли, обратите внимание на пробелы и слово Sum:
Sum = 60

*/
class TaskC1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int sum = 0;
        for (int i = 0; i < 2; i++) {
           sum = sum + sc.nextInt();
        }
        System.out.println("Sum = " + sum);
    }
}
