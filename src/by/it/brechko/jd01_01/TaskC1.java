package by.it.brechko.jd01_01;

import com.sun.source.doctree.SummaryTree;
import org.hamcrest.core.SubstringMatcher;

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
        Scanner sc = new Scanner(System.in);
        System.out.println("Sum " + "= " + (sc.nextInt() + sc.nextInt()));


    }
}






