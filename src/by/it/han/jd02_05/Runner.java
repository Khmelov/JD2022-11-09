package by.it.han.jd02_05;

import by.it.han.jd02_05.constants.Message;
import by.it.han.jd02_05.constants.User;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Runner {
    private static final String DATE_FORMATTER = "HH:mm, dd MMMM yyyy";
    private static final String RU = "ru";
    private static final String EN = "en";
    private static final String BE = "be";

    public static void main(String[] args) {
        ResMan resMan = ResMan.INSTANCE;
        Locale locale = Locale.ENGLISH;
        locale = getLocale(resMan, locale);
        resMan.setLocal(locale);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER, locale);
        printResult(resMan, formatter);
    }

    private static Locale getLocale(ResMan resMan, Locale locale) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(resMan.get(Message.QUESTION));
        String input = scanner.nextLine().toLowerCase(locale);
        if (input.equalsIgnoreCase(resMan.get(User.ANSWER))) {
            System.out.println(resMan.get(Message.PRINT_LOCAL));
            input = scanner.nextLine();
            switch (input.toLowerCase()) {
                case RU -> locale = new Locale(RU);
                case EN -> locale = new Locale(EN);
                case BE -> locale = new Locale(BE);
                default -> System.out.println(resMan.get(Message.NO_SUCH_LOCALE));
            }
        }
        return locale;
    }

    private static void printResult(ResMan resMan, DateTimeFormatter formatter) {
        System.out.println(LocalDateTime.now().format(formatter));
        System.out.println(resMan.get(Message.WELCOME));
        System.out.println(resMan.get(User.FIRSTNAME));
        System.out.println(resMan.get(User.LASTNAME));
    }
}
