package by.it.boycova.jd01_01;

/* Нужно написать программу, которая вводит два числа с клавиатуры
и выводит их сумму на экран в виде

Ввод (это вы вводите с клавиатуры):
34 26

Вывод (это должно появиться в консоли, обратите внимание на пробелы и слово Sum:
Sum = 60

*/
import java.util.Scanner;
public class TaskC1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1=sc.nextInt();
        int num2= sc.nextInt();
        int Sum=num1+num2;
        System.out.println("Sum ="+" "+Sum);

    }





}
