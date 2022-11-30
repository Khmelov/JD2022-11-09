package by.it.vasileuskaya.jd01_01;

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
        Scanner cons = new Scanner(System.in);
        int a = cons.nextInt();
        int b = cons.nextInt();
        int sum = a + b;

        String bina = Integer.toBinaryString(a);
        String binb = Integer.toBinaryString(b);
        String binsum = Integer.toBinaryString(sum);

        String hexa = Integer.toHexString(a);
        String hexb = Integer.toHexString(b);
        String hexsum = Integer.toHexString(sum);

        String octa = Integer.toOctalString(a);
        String octb = Integer.toOctalString(b);
        String octsum = Integer.toOctalString(sum);

        System.out.println("DEC:" + a + "+" + b + "=" + sum);
        System.out.println("BIN:" + bina + "+" + binb + "=" + binsum);
        System.out.println("HEX:" + hexa + "+" + hexb + "=" + hexsum);
        System.out.println("OCT:" + octa + "+" + octb + "=" + octsum);

    }


}
