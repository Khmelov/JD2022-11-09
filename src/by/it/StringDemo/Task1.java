package by.it.StringDemo;
/* Задание 1.
a) Напишите метод, который принимает в качестве параметра любую строку, например “I like Java!!!”.
б) Распечатать последний символ строки. Используем метод String.charAt().
в) Проверить, заканчивается ли ваша строка подстрокой “!!!”. Используем метод String.endsWith().
г) Проверить, начинается ли ваша строка подстрокой “I like”. Используем метод String.startsWith().
д) Проверить, содержит ли ваша строка подстроку “Java”. Используем метод String.contains().
e) Найти позицию подстроки “Java” в строке “I like Java!!!”.
ж) Заменить все символы “а” на “о”.
з) Преобразуйте строку к верхнему регистру.
и) Преобразуйте строку к нижнему регистру.
к) Вырезать строку Java c помощью метода String.substring(). */


public class Task1 {
    public static void main(String[] args) {
        String name = "I like Java!!!";
        System.out.println(name);
        System.out.println("б) " + name.charAt(13));
        System.out.println("в) " + name.endsWith("!!!"));
        System.out.println("г) " + name.startsWith("I Like"));
        System.out.println("д) " + false);
        System.out.println("e) " + name.indexOf("Java"));
        System.out.println("ё) " + name.replace("a", "о"));
        System.out.println("ж) " + name.toUpperCase());
        System.out.println("з) " + name.toLowerCase());
        System.out.println(("и) " + name.substring(7, 11)));
    }
}
