package by.it.bolshakov.jd01_06;

import java.util.Arrays;
import java.util.Comparator;

public class TaskB2 {
    public static void main(String[] args) {
        //String text = Poem.text.replaceAll("[^а-яёА-ЯЁ.]", " ").replaceAll("...", " ").replaceAll("\s+", " ");
        String[] sentences = Poem.text.replace("...", "")
                                .replaceAll("[-,:]", " ")
                                .replaceAll("\\s+", " ")
                                .replace('!', '.').split("\\.");
        String[] trimmedSentences = Arrays.stream(sentences).map(String::trim)
                                                            .sorted(Comparator.comparingInt(String::length))
                                                            .toArray(String[]::new);
        for (String sentence: trimmedSentences) {
            System.out.print(sentence+"\n");
        }
    }
}
