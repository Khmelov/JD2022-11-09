package by.it.vasileuskaya.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {
    private static String[] words = new String[0];
    private static int[] counter = new int[0];

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яёА-ЯЁ]+");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            String word = matcher.group();
            checkWordForRepeat(word);
        }
        showNumberRepeat();
    }

    private static void checkWordForRepeat(String word) {
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word)) {
                counter[i]++;
                return;
            }
        }
        words = Arrays.copyOf(words, words.length + 1);
        words[words.length - 1] = word;
        counter = Arrays.copyOf(counter, counter.length + 1);
        counter[counter.length - 1] = 1;
    }

    private static void showNumberRepeat() {
        for (int i = 0; i < words.length; i++) {
            System.out.printf("%s=%d%n", words[i], counter[i]);
        }
    }
}
