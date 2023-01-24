package by.it.samatokhin.jd02_05;

import by.it.samatokhin.jd02_05.constans.Message;
import by.it.samatokhin.jd02_05.constans.User;

import java.util.Locale;

public class Runner {
    public static void main(String[] args) {
        ResMan resMan = ResMan.INSTANCE;

        Locale locale = args.length == 2
                ? new Locale(args[0], args[1])
                : Locale.ENGLISH;
        System.out.println(ResMan.get(Message.WELCOME));
        System.out.println(ResMan.get(Message.QUESTION));
        System.out.println(ResMan.get(User.FIRST_NAME));
        System.out.println(ResMan.get(User.LAST_NAME));
    }
}
