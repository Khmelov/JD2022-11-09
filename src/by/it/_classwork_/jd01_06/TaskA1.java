package by.it._classwork_.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яёА-ЯЁ]{4,}");
        StringBuilder text = new StringBuilder(Poem.text);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {

            int start = matcher.start();
            text.setCharAt(start + 3, '#');
            if (matcher.end() - start > 6) {
                text.setCharAt(start + 6, '#');
            }
        }
        System.out.println(text);
    }
}
