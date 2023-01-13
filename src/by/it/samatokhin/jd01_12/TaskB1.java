package by.it.samatokhin.jd01_12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class TaskB1 {

    public static void main(String[] args) {
        ArrayList<String> wordList = collectScannerValues();
        HashMap<String, Integer> wordMap = new HashMap<>();

        for (String word : wordList) {
            if (wordMap.containsKey(word)) {
                Integer count = wordMap.get(word);
                count++;
                wordMap.put(word, count);
            } else {
                wordMap.put(word, 1);
            }
        }

        for (HashMap.Entry<String, Integer> set : wordMap.entrySet()) {
            System.out.println(set.getKey() + "=" + set.getValue());
        }
    }

    private static ArrayList<String> collectScannerValues() {
        ArrayList<String> wordList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String value = scanner.next();
            if (value.equals("end")) {
                break;
            } else {
                value = value.replaceAll("[^a-zA-Z0-9\\']+", "");
                if (value.toLowerCase().equals("isn't")) {
                    value = value.replaceAll("isn't", "don't");
                }
                wordList.add(value);
            }
        }
        return wordList;
    }
}
