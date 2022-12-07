package by.it.bogumil.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {

    static String[] words = new String[0];
    static int[] counters = new int[0];

    public static void main(String[] args) {
        String text = Poem.text;
        Pattern pattern = Pattern.compile("[А-Яа-яЁё]+");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String word = matcher.group();
            getWord(word);
        }
        statistic();
    }

    static void getWord(String word) {
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word)) {
                counters[i]++;
                return;
            }
        }
        words = Arrays.copyOf(words, words.length + 1);
        words[words.length - 1] = word;
        counters = Arrays.copyOf(counters, counters.length + 1);
        counters[counters.length - 1] = 1;
    }

    static void statistic() {
        for (int i = 0; i < words.length; i++) {
            System.out.printf("%s=%d%n", words[i], counters[i]);
        }
    }
}

