package by.it.boycova.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args) {
        Pattern sample = Pattern.compile("[а-яЁёА-Я]{4,}");
        StringBuilder textPoem = new StringBuilder(Poem.text);
        Matcher matcher= sample.matcher(textPoem);
        while(matcher.find()) {
            int start= matcher.start();
            textPoem.setCharAt(start+3,'#');
            if(matcher.end()-start>6) {
                textPoem.setCharAt(start + 6, '#');
            }
        }
        System.out.println(textPoem);
    }
}
