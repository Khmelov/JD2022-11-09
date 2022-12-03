package by.it.bogumil.jd01_01;

import java.util.Scanner;

/* Нужно написать программу, которая вводит два числа с клавиатуры
и 4 раза выводит их сумму с обозначением системы счисления на экран в
ДЕСЯТИЧНОМ ДВОИЧНОМ ШЕСТНАДЦАТИРИЧНОМ ВОСЬМИРИЧНОМ виде

Вот пример ввода с клавиатуры:
34 26

Тогда вывод ожидается такой (обратите внимание на регистр букв):
DEC:34+26=60
BIN:100010+11010=111100
HEX:22+1a=3c
OCT:42+32=74

Допускается свободное использование любых методов стандартной библиотеки
*/
class TaskC2 {
    public static void main(String[] args) {
        int DEC = 0;
        int BIN = 0;
        int HEX = 0;
        int OCT = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число: 34");
        int b = sc.nextInt();
        System.out.println("Введите 2-ое число: 26");
        int c = sc.nextInt();
        DEC = b + c;
        System.out.println("DEC:" + b + "+" + c + "=" + DEC);
        System.out.println("BIN:" + Integer.toBinaryString(b) + "+" + Integer.toBinaryString(c) + "=" + Integer.toBinaryString(b + c));
        System.out.println("HEX:" + Integer.toHexString(b) + "+" + Integer.toHexString(c) + "=" + Integer.toHexString(b + c));
        System.out.println("OCT:" + Integer.toOctalString(b) + "+" + Integer.toOctalString(c) + "=" + Integer.toOctalString(b + c));
    }
}
