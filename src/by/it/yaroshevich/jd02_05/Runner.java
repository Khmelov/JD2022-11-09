package by.it.yaroshevich.jd02_05;

import by.it.yaroshevich.jd02_05.constans.Message;
import by.it.yaroshevich.jd02_05.constans.User;

import java.util.Locale;

public class Runner {
    public static void main(String[] args) {
        ResourceManager resourceManager = ResourceManager.INSTANSE;

            Locale locale = args.length == 2
                ? new Locale(args[0], args[1])
                : Locale.ENGLISH;

        resourceManager.setLocale(locale);
        System.out.println(resourceManager.get(Message.WELCOME));
        System.out.println(resourceManager.get(Message.QUESTION));
        System.out.println(resourceManager.get(User.FIRST_NAME));
        System.out.println(resourceManager.get(User.LAST_NAME));
    }
}
