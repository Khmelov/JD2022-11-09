package by.it.yaroshevich.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        resultWord();
    }

    private static void resultWord() {
      //  String letters1 = "БбВвГгДдЖжЗзЙйКкЛлМмНнПпРрСсТтФфХхЦцЧчШшЩщ";
        String text = Poem.text.replaceAll("[,!:.-]", "").trim();
        String [] wordArray = text.split(" ");
        for (String word: wordArray){
            System.out.println(word);
        }
    }
}