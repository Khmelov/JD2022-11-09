package by.it.yaroshevich.jd01_06;

import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {
        String text = Poem.text.replaceAll("[\\s,:-]+", " ");

        String[] array = text.split("[.!]");
        Arrays.sort(array, Comparator.comparingInt(String::length));
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i].trim());
        }
    }
}

