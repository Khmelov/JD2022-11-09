package by.it.bolshakov.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {

    private static boolean isVowel (Character letter) {
        boolean isVowel = false;
        switch (Character.toLowerCase(letter)) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'а':
            case 'о':
            case 'и':
            case 'у':
            case 'э':
            case 'ё':
            case 'ы':
            case 'я':
            case 'ю':
            case 'е':
                isVowel = true;
                break;
            default:
                isVowel = false;
                break;
        }
        return isVowel;
    }

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яёА-ЯЁ]+");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            String word = matcher.group();
            if (isVowel(word.charAt(0))==false & isVowel(word.charAt(word.length()-1))==true) {
                System.out.println(word);
            }
        }
    }
}
