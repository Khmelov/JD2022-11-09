package by.it.boycova.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        Pattern letter= Pattern.compile("\\b[ЦКНГШЩЗХФВПРЛДЖЧСМТБцкнгшщзхфвпрлджчсмтб]\\S*[ауеоэиюяыё]\\b");
        Matcher matcher= letter.matcher(Poem.text);
        while (matcher.find()) {
            String word = matcher.group();
            System.out.println(word);
        }
    }

}
