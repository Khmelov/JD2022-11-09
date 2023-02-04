package by.it.bolshakov.jd02_05;

import by.it.bolshakov.jd02_05.constants.Message;
import by.it.bolshakov.jd02_05.constants.User;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Runner {

    public static final String DATE_FORMAT = "HH:mm:ss, dd MMMM yyyy";
    public static final String RUSSIAN_LOCALE = "ru";
    public static final String ENGLISH_LOCALE = "en";
    public static final String BELARUSIAN_LOCALE = "be";
    public static final String NO_LOCALE_ERROR_MSG = "Такой язык не поддерживается, язык по-умолчанию: en";
    public static final String EN_ZONE_ID = "Europe/London";
    public static final String BE_ZONE_ID = "Europe/Minsk";
    public static final String RU_ZONE_ID = "Europe/Moscow";

    public static void main(String[] args) {
        by.it.bolshakov.jd02_05.ResMan resMan = ResMan.INSTANCE;
        Locale locale = args.length == 2
                ? new Locale(args[0], args[1])
                : Locale.ENGLISH;

        ZoneId zoneId = ZoneId.of(EN_ZONE_ID);
        System.out.println("Выберите язык (ru/en/by): ");
        Scanner scanner = new Scanner(System.in);
        loop : while (true) {
            String userInput = scanner.nextLine();
            switch (userInput) {
                case (RUSSIAN_LOCALE): locale = new Locale(RUSSIAN_LOCALE); zoneId = ZoneId.of(RU_ZONE_ID); break;
                case (ENGLISH_LOCALE): locale = new Locale(ENGLISH_LOCALE); zoneId = ZoneId.of(EN_ZONE_ID); break;
                case (BELARUSIAN_LOCALE): locale = new Locale(BELARUSIAN_LOCALE); zoneId = ZoneId.of(BE_ZONE_ID); break;
                case ("exit"): break loop;
                default: System.out.println(NO_LOCALE_ERROR_MSG); locale = new Locale(ENGLISH_LOCALE); break;
            }
            resMan.setLocale(locale);
            printLocaleText(resMan, locale, zoneId);
        }

    }
    private static void printLocaleText(ResMan resMan, Locale locale, ZoneId zoneId) {
        ZonedDateTime zdt = ZonedDateTime.now(zoneId) ;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT, locale);
        System.out.println(zdt.format(formatter));
        System.out.println(resMan.get(Message.WELCOME));
        System.out.println(resMan.get(Message.QUESTION));
        System.out.println(resMan.get(User.FIRST_NAME));
        System.out.println(resMan.get(User.LAST_NAME));
    }
}
