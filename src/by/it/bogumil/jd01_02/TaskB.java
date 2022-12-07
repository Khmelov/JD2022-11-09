package by.it.bogumil.jd01_02;
/*В классе TaskB (пакет by.it.familiya.jd01_02) создайте Scanner и методы:

static void step1()
static void step2(int month)
static void step3(double a, double b, double c)

вызовите их один раз из метода main. Эти методы решают такие задачи:
1. step1() выводит числа от 1 до 25 в виде матрицы N x N слева направо и
сверху вниз (т.е. N = 5). После каждого числа один пробел.
2. В main ввести с консоли через объект типа Scanner число от 1 до 12 и с
ним вызвать метод step2(int month), который выводит на консоль русское
название месяца строчными буквами, соответствующего этому числу через
switch. Сообщить об ошибке “нет такого месяца” для некорректных чисел
во вводе (это должна быть default – ветка для switch).
3. Рассчитайте и выведите корни (или один корень) квадратного уравнения.
Если корня нет, то нужно вывести сообщение “корней нет”.
Параметры (a b c) уравнения нужно вводить в main через тот же Scanner и
затем передавать в метод step3(double a, double b, double c).
Для извлечения D используйте метод Math.sqrt(дискриминант) */

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число от 1 до 12:");
        int month = sc.nextInt();

        step1();
        step2(month);

        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        step3(a, b, c);
    }


    private static void step1() {
        int massiv[][] = new int[5][5];
        int k = 1;

        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++) {
                massiv[i][j] = k;
                k++;
            }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++)
                System.out.print(massiv[i][j] + " ");
            System.out.println();
        }

    }

    static void step2(int month) {

        switch (month) {
            case 0:
                System.out.println("нет такого месяца");
                break;
            case 1:
                System.out.println("январь");
                break;
            case 2:
                System.out.println("февраль");
                break;
            case 3:
                System.out.println("март");
                break;
            case 4:
                System.out.println("апрель");
                break;
            case 5:
                System.out.println("май");
                break;
            case 6:
                System.out.println("июнь");
                break;
            case 7:
                System.out.println("июль");
                break;
            case 8:
                System.out.println("август");
                break;
            case 9:
                System.out.println("сентябрь");
                break;
            case 10:
                System.out.println("октябрь");
                break;
            case 11:
                System.out.println("ноябрь");
                break;
            case 12:
                System.out.println("декабрь");
                break;
            default:
                System.out.println("нет такого месяца");
        }

    }

    static void step3(double a, double b, double c) {

        double discriminant = b * b - 4 * a * c;
        if (discriminant < 0)
            System.out.println("корней нет");
        else if (discriminant == 0) {
            double x = Math.round((-b / (2 * a)) * 100);
            System.out.println("один корень: " + x / 100);
        } else if (discriminant > 0) {
            double x1 = Math.round(((-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a)) * 100);
            double x2 = Math.round(((-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a)) * 100);
            System.out.println("два корня: " + x1 / 100 + ", " + x2 / 100);
        }
    }
}














