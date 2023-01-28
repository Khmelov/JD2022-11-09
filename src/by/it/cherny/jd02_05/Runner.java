package by.it.cherny.jd02_05;

import by.it.cherny.jd02_05.Constants.Message;
import by.it.cherny.jd02_05.Constants.User;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Runner {
    public static void main(String[] args) {
        ResMan resMan = ResMan.INSTANSE;

        Locale locale = (args.length == 2)
                ? new Locale(args[0], args[1])
                : Locale.ENGLISH;

        resMan.setLocale(locale);

        System.out.println(resMan.get(Message.WELCOME));
        System.out.println(resMan.get(Message.QUESTION));
        System.out.println(resMan.get(User.FIRST_NAME));
        System.out.println(resMan.get(User.LAST_NAME));

        Date date = new Date();
//        System.out.println(date.toLocaleString());
        DateFormat timeInstance = DateFormat.getTimeInstance(DateFormat.DEFAULT, locale);
        DateFormat df = new SimpleDateFormat("dd MMM yyy");
        Calendar calendar = timeInstance.getCalendar();
        System.out.println(calendar.getTime());
        System.out.println(df.format(date));

    }
}
