package by.it.yaroshevich.jd01_01;

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
            int A=sc.nextInt();
            int B=sc.nextInt();

            int C = A+B;

            System.out.print("Sum = " + C);
        }
    }