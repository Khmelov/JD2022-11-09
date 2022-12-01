package by.it.cherny.jd01_06;

import java.util.Arrays;

public class TaskC2 {
    public static void main(String[] args) {
        String poem = Poem.text;

        String randomWords = getRandomWords(poem);

        long startTime1 = System.nanoTime();
        String str1 = slow(randomWords);
        long elapsedTime1 = System.nanoTime() - startTime1;
        System.out.println("slow "+elapsedTime1/1000000);

        long startTime2 = System.nanoTime();
        String str2 = fast(randomWords);
        long elapsedTime2 = System.nanoTime() - startTime2;
        System.out.println("fast "+elapsedTime2/1000000);

//        System.out.println(str1);
//        System.out.println(str2);
        System.out.println("Отличие в скорости "+(elapsedTime1/elapsedTime2));
    }

    private static String getRandomWords(String text) {
        return random(text);
    };

//    private static String slow(String text) {
//        String[] strings = text.split("[^а-яА-ЯёЁ]+");
//        String newString="";
//        for (int i = 0; i < 100000; i++) {
//            int randomId = (int)Math.floor(Math.random() * strings.length);
//            newString+=strings[randomId]+" ";
//        }
//        return newString;
//    };
    private static String random(String text){
        String[] strings = text.split("[^а-яА-ЯёЁ]+");
        StringBuilder sbText = new StringBuilder("");
        for (int i = 0; i < 100000; i++) {
            int randomId = (int)Math.floor(Math.random() * strings.length);
            sbText.append(strings[randomId]);
            sbText.append(" ");
        }
        return String.valueOf(sbText);
    };

    private static String slow(String text) {
        String[] strings = text.split(" ");
        String newString="";
        for (int i = 0; i < strings.length; i++) {
            newString+=strings[i]+" ";
        }
        return newString;
    };
    private static String fast(String text){
        String[] strings = text.split(" ");
        StringBuilder sbText = new StringBuilder("");
        for (int i = 0; i < strings.length; i++) {
            sbText.append(strings[i]);
            sbText.append(" ");
        }
        return String.valueOf(sbText);
    };
}
