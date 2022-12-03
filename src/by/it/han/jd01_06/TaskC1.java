package by.it.han.jd01_06;

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

    private static void formattedText(String text, int maxSentencesLength) {
        String[] split = text.split("\n");
        for (String sentences : split) {
            if (sentences.length() < maxSentencesLength) {
                sentences = addSpace(sentences, maxSentencesLength);
            }
            System.out.println(sentences);
        }
    }

    private static String addSpace(String sentences, int maxSentencesLength) {
        String[] arr = sentences.split(" ");
        String[] newArr = new String[arr.length];
        int lengthSentences = sentences.toCharArray().length;
        int needSpace = maxSentencesLength - lengthSentences;
        boolean isFirstRepeat = true;
        newArr[arr.length - 1] = arr[arr.length - 1];
        while (needSpace > 0) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (needSpace == 0 && !isFirstRepeat) {
                    break;
                }
                if (isFirstRepeat && needSpace > 0) {
                    newArr[i] = arr[i] + "  ";
                } else if (isFirstRepeat) {
                    newArr[i] = arr[i] + " ";
                } else {
                    newArr[i] = newArr[i] + " ";
                }
                needSpace--;
            }
            isFirstRepeat = false;
        }
        return getText(newArr).toString();
    }

    private static StringBuilder getText(String[] newArr) {
        StringBuilder text = new StringBuilder();
        for (String str : newArr) {
            text.append(str);
        }
        return text;
    }
}

