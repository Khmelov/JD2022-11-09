package by.it.han.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {
    public static void main(String[] args) {
        printText();
    }

    private static void printText() {
        String text = Poem.text;
        int maxSentencesLength = getMaxSentencesLength(text);
        formattedText(text, maxSentencesLength);
    }

    private static int getMaxSentencesLength(String text) {
        String[] split = text.split("\n");
        int max = 0;
        for (String s : split) {
            if (s.length() > max) {
                max = s.length();
            }
        }
        return max;
    }

    private static String formattedText(String text, int maxSentencesLength) {
        String[] split = text.split("\n");
        for (String s : split) {
            if (s.length() < maxSentencesLength) {
                s = getNewString(s, maxSentencesLength);
                s = addSpace(s);
//                System.out.println(s + " " + s.length());
            } else {
                System.out.println(s + " " + s.length());
            }
        }
        return text;
    }

    private static String getNewString(String s, int maxSentencesLength) {
        String[] split = s.split("\n");
        StringBuilder newString = new StringBuilder(s);
        int lengthString = 0;
        for (String str : split) {
            lengthString += str.length();
        }
        Pattern pattern = Pattern.compile("[А-Яа-яЁё]+");
        Matcher matcher = pattern.matcher(s);
        int countWords = getCountWords(matcher);
        while (lengthString < maxSentencesLength) {
            for (int i = 0; i < countWords; i++) {
                if (lengthString < maxSentencesLength) {
                    newString.append(" ");
                } else {
                    break;
                }
                lengthString++;
            }
        }
        return newString.toString();
    }

    private static int getCountWords(Matcher matcher) {
        int countWords = 0;
        while (matcher.find()) {
            countWords++;
        }
        return countWords;
    }

    private static String addSpace(String text) {
        char[] arr = text.toCharArray();
        char[] newArr = new char[arr.length];
        Pattern pattern = Pattern.compile("[А-Яа-яЁё]+");
        Matcher matcher = pattern.matcher(text);
        int countWords = getCountWords(matcher);
        int count = newArr.length;
        for (int i = 0, j = 0; j < newArr.length; i++) {
            if (arr[i] != ' ') {
                newArr[j] = arr[i];
                j++;
                count--;
            } else {
                j += countWords - 1;
            }
        }
        System.out.println(newArr);
        return "";
    }

    private static String mergeArrayStrings(String[] arr) {
        StringBuilder text = new StringBuilder();
        for (String s : arr) {
            if (s == null) {
                text.append(" ");
            } else {
                text.append(s);
            }
        }
        System.out.println(text);
        return text.toString();
    }
}

