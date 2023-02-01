package by.it.cherny.jd02_05;

import by.it.cherny.jd02_05.Constants.Message;
import by.it.cherny.jd02_05.Constants.User;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ResMan resMan = ResMan.INSTANSE;
        Locale locale = args.length == 2
                ? new Locale(args[0], args[1])
                : Locale.getDefault();

        resMan.setLocale(locale);

        printMessages(resMan, locale);

        while (scanner.hasNext()){
            String next = scanner.next();
            switch (next){
                case "en": {
                    resMan.setLocale(Locale.ENGLISH);
                    printMessages(resMan, Locale.ENGLISH);
                    break;
                }
                case "ru": {
                    resMan.setLocale(Locale.getDefault());
                    printMessages(resMan, Locale.getDefault());
                    break;
                }
                case "be": {
                    resMan.setLocale(new Locale("be"));
                    printMessages(resMan, new Locale("be"));
                    break;
                }
                case "end": return;
                default:
                    System.out.println("Enter ru, be or en");
                    break;
            }
        }
    }

    private static void printMessages(ResMan resMan, Locale locale) {
        System.out.println(resMan.get(Message.WELCOME));
        System.out.println(resMan.get(Message.QUESTION));
        System.out.println(resMan.get(User.FIRST_NAME));
        System.out.println(resMan.get(User.LAST_NAME));

        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);
        String formattedDate = df.format(new Date());
        System.out.println(formattedDate);
    }
}
