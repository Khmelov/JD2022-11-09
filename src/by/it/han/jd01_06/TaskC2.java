package by.it.han.jd01_06;

import static by.it.han.jd01_06.TaskB2.getModifiedArray;

public class TaskC2 {

    private static final int COUNT_LETTERS = 110_000;

    public static void main(String[] args) {
        String text = Poem.text;
        String randomWords = getRandomWords(text);
        long startTimeSlow = System.currentTimeMillis();
        System.out.println(slow(randomWords));
        long endTimeSlow = System.currentTimeMillis();
        long resultSlow = endTimeSlow - startTimeSlow;
        long startTimeFast = System.currentTimeMillis();
        System.out.println(fast(randomWords));
        long endTimeFast = System.currentTimeMillis();
        long resultFast = endTimeFast - startTimeFast;
        System.out.printf("slow dt=%d%n", resultSlow);
        System.out.printf("fast dt=%d%n", resultFast);
        System.out.printf("Отличие в скорости  dtSlow/dtFast=%d%n", resultSlow / resultFast);
    }

    private static String slow(String text) {
        String[] words = getArrayWords(text);
        return concat(words);
    }

    private static String fast(String text) {
        String[] words = getArrayWords(text);
        return append(words);
    }

    private static String[] getArrayWords(String text) {
        String[] sentences = getModifiedArray(text);
        String sentencesString = getWordsString(sentences);
        return sentencesString.split(" ");
    }

    private static String getWordsString(String[] words) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : words) {
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }

    private static String concat(String[] words) {
        String text = "";
        for (int i = 0; i < words.length; i++) {
            text = text.concat(words[i]);
            if (i != words.length - 1) {
                text = text.concat(" ");
            }
        }
        return text;
    }

    private static String append(String[] words) {
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            text.append(words[i]);
            if (i != words.length - 1) {
                text.append(" ");
            }
        }
        return text.toString();
    }

    private static String getRandomWords(String text) {
        String[] words = getArrayWords(text);
        StringBuilder sb = new StringBuilder();
        int count = sb.length();
        while (count < COUNT_LETTERS) {
            int i = (int) (Math.random() * 157);
            sb.append(words[i]);
            count = sb.length();
            if (count < COUNT_LETTERS) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
