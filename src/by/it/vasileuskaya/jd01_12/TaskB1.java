package by.it.vasileuskaya.jd01_12;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TaskB1 {
    public static void main(String[] args) {
        String text = Test_jd01_12.text;
        String textNew = text.replaceAll("[^A-Za-z'\s\n]", "");
        System.out.println(textNew);
        String[] arrayFromText = textNew.split("[^A-Za-z']+");
        System.out.println(Arrays.toString(arrayFromText));
        HashMap<String, Integer> wordsAndFrequency = new HashMap<>();
        for (String i : arrayFromText) {
            if (wordsAndFrequency.containsKey(i)) {
                wordsAndFrequency.put(i, wordsAndFrequency.get(i) + 1);
            } else {
                wordsAndFrequency.put(i, 1);
            }
        }
        for (Map.Entry<String, Integer> result : wordsAndFrequency.entrySet()) {
            System.out.printf("%s=%d\n", result.getKey(), result.getValue());
        }
    }
}
