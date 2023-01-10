package by.it.samatokhin.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {

    private static final String vowelsStr = "аоуэиыеёяюАОУЭИЫЕЁЯЮ";
    private static final String consonantsStr = "йцкнгшщзхфвпрлджбтмсчЙЦКНГШЩЗХФВПРЛДЖБТМСЧ";

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            String word = matcher.group();
            if (wordChecker(word)) {
                System.out.println(word);
            }
        }
    }

    private static boolean wordChecker(String str) {
        boolean match = false;
        String firstChar = str.substring(0, 1);
        String lastChar = str.substring(str.length() - 1, str.length());

        if (consonantsStr.contains(firstChar) && vowelsStr.contains(lastChar)) {
            match = true;
        }
        return match;
    }
}
