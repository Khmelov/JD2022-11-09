package by.it.han.jd01_06;

import java.util.Arrays;

public class TaskB2 {
    public static void main(String[] args) {
        printSentences();
    }

    private static void printSentences() {
        String[] strings = getSortStrings();
        for (String s : strings) {
            System.out.println(s.trim());
        }
    }

    private static String[] getSortStrings() {
        String[] words = getModifiedArray();
        Arrays.sort(words, new StringLengthComparator());
        return words;
    }


    private static String[] getModifiedArray() {
        return Poem.text
                .replace("...", "")
                .replaceAll("[-,:]", "")
                .replaceAll("\\s+", " ")
                .replace('!', '.').split("\\.");
    }
}
