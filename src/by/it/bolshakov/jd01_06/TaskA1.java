package by.it.bolshakov.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яёА-ЯЁ]{4,}");
        StringBuilder text = new StringBuilder(Poem.text);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            text.setCharAt(matcher.start() + 3,'#');
            if (matcher.group().length() >= 7) {
                text.setCharAt(matcher.start() + 6,'#');
            }
        }
        System.out.println(text);
    }
}
