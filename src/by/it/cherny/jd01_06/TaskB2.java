package by.it.cherny.jd01_06;

import java.util.Arrays;
import java.util.Comparator;

public class TaskB2 {
    public static void main(String[] args) {
        String text = Poem.text.replaceAll("[^а-яёА-ЯЁ.]", " ")
                .replaceAll("\s+"," ")
                .replaceAll("[.]{2,}"," ");
        String[] sentences = text.split("\\.");
        String[] trimmedSentences = new String[sentences.length];
        for (int i = 0; i < sentences.length; i++) {
            trimmedSentences[i] = sentences[i].trim();
        }
        Arrays.sort(trimmedSentences, Comparator.comparingInt(String::length));
        for (String sentence: trimmedSentences) {
            System.out.println(sentence);
        }
    }
}
