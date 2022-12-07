package by.it.bogumil.jd01_02;

import java.util.Scanner;

/* В методе main введите 10 чисел с консоли в массив arr через объект типа
Scanner. Пример: Scanner scanner=new Scanner(System.in);
В классе TaskA создайте статические методы
static void step1(int[ ] arr)
static void step2(int[ ] arr)
static void step3(int[ ] arr)
и вызовите их из метода main. Эти методы решают такие задачи:
1. Найти самое маленькое и самое большое число массива. Вывести на
консоль найденные минимум и максимум в одну строку через пробел.
2. Вывести на консоль те числа, значение которых строго меньше
среднего арифметического (типа double) в этом массиве.
3. Найти и вывести номер (т.е. индекс) самого маленького числа.
Если же таких чисел будет несколько, вывести все найденные индексы
минимума через пробел в порядке убывания. */
public class TaskA {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите 10 чисел:");
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        step1(arr);
        step3(arr);
        step2(arr);
    }

    private static void step1(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        System.out.println(min + " " + max);
    }

    private static void step2(int[] arr) {
        double dvs = 0;
        for (int sam : arr) {
            dvs = dvs + sam;
        }
        dvs = dvs / arr.length;
        for (int sam : arr) {
            if (sam < dvs)
                System.out.print(sam + " ");

        }


    }


    static void step3(int[] arr) {
        int min = arr[0];
        for (int element : arr) {
            if (min > element)
                min = element;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == min)
                System.out.print(i + " ");

        }

    }

}



