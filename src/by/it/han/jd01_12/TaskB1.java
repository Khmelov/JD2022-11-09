package by.it.han.jd01_12;

import java.util.*;

public class TaskB1 {

    private static final String REGEX = "[\"#%&)($*,+-.:;}{_~@!№=]";

    public static void main(String[] args) {
        List<String> words = getWordsList();
        Map<String, Integer> map = getWordsAndCount(words);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.printf("%s=%s%n", entry.getKey(), entry.getValue());
        }
    }

    private static Map<String, Integer> getWordsAndCount(List<String> words) {
        Map<String, Integer> map = new HashMap<>(words.size());
        for (int i = 0; i < words.size(); i++) {
            if (!map.containsKey(words.get(i))) {
                int count = 0;
                for (String word : words) {
                    if (words.get(i).equals(word)) {
                        count++;
                    }
                }
                map.put(words.get(i), count);
            }
        }
        return map;
    }

    private static List<String> getWordsList() {
        Scanner sc = new Scanner(System.in);
        List<String> words = new ArrayList<>(100);
        while (true) {
            String word = sc.next();
            if (word.equalsIgnoreCase("end")) {
                break;
            }
            String refactorWord = word.trim().replaceAll(REGEX, "");
            words.add(refactorWord);
        }
        return words;
    }
}
