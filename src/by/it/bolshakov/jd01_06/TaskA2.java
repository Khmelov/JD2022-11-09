package by.it.bolshakov.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {
    private static String[] words = new String[0];
    private static int[] countWords = new int[0];

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яёА-ЯЁ]+");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            String word = matcher.group();
            countWord(word);
        }
        showStats();
    }

    private static void countWord(String word) {
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word)){
                countWords[i]++;
                return;
            }
        }
        words=Arrays.copyOf(words,words.length+1);
        words[words.length-1] = word;
        countWords=Arrays.copyOf(countWords,countWords.length+1);
        countWords[countWords.length-1] = 1;
    }

    private static void showStats() {
        for (int i = 0; i < words.length; i++) {
            System.out.printf("%s=%d%n",words[i],countWords[i]);
        }
    }

}
