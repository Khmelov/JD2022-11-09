package by.it.yaroshevich.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        resultWord();
    }

    private static void resultWord() {
        String letters1 = "БбВвГгДдЖжЗзЙйКкЛлМмНнПпРрСсТтФфХхЦцЧчШшЩщ";
        String [] wordArray = Poem.text.split("[\\s,.:!?]+");
        for (String word: wordArray){
            if (letters1.contains(word.substring(0,1))){
                    System.out.println(word);

            }
        }
    }
}