package by.it.vasileuskaya.jd02_05;

import by.it.vasileuskaya.jd02_05.constant.Message;
import by.it.vasileuskaya.jd02_05.constant.User;

import java.util.Locale;

public class Runner {
    public static void main(String[] args) {
        ResMan resMan = ResMan.INSTANCE;
        Locale locale = args.length == 2
                ? new Locale(args[0], args[1])
                : Locale.ENGLISH;
        resMan.setLocale(locale);

        System.out.println(resMan.get(Message.WELCOME));
        System.out.println(resMan.get(Message.QUESTION));
        System.out.println(resMan.get(User.FIRSTNAME));
        System.out.println(resMan.get(User.LASTNAME));
        System.out.println();

    }
}
