package by.it.StringDemo;

/*Задание 2.

а) Дано два числа, например 3 и 56, необходимо составить следующие строки:
	3 + 56 = 59
	3 – 56 = -53
	3 * 56 = 168.
	Используем метод StringBuilder.append().
б) Замените символ “=” на слово “равно”.
Используйте методы StringBuilder.insert(), StringBuilder.deleteCharAt().
в) Замените символ “=” на слово “равно”.
Используйте методы StringBuilder.replace().*/
public class Task2 {
    public static void main(String[] args) {

        StringBuilder stringBuilder = new StringBuilder("3 + 56 = 59\n" +
                "\t3 – 56 = -53\n" +
                "\t3 * 56 = 168");
        System.out.println(stringBuilder);
    }
}
