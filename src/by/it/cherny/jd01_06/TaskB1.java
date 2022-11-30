package by.it.cherny.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
//    private static String[] words = new String[0];
    private static String[] letters = {"а","о","у","ы","э","я","ё","ю","и","И","е"};
    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[а-яёА-ЯЁ]+");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()){
            String word = matcher.group();
            if (word.length()>1)
                isTrue(word);
        }
    }
    private static void isTrue(String word) {
        String wordStarts = String.valueOf(word.charAt(0));
        String wordEnds = String.valueOf(word.charAt(word.length()-1));
        for (String s : letters) {
            if (wordStarts.equals(s))
                return;
        }
//        for (String letter : letters) {
//            if (!wordStarts.equals(letter)) {
                for (String letter1 : letters) {
                    if (wordEnds.equals(letter1)) {
                        System.out.printf("%s\n", word);
                        return;
                    }
//                }
//            }
//            return;
        }
    }
}
