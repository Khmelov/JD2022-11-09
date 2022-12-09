package by.it.boycova.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {
    
    private static String[]sortedWords=new String[0];
    private static int[]counterWords=new int[0];


    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яЁёА-Я]+");
        Matcher matcher= pattern.matcher(Poem.text);
        while (matcher.find()){
            String word= matcher.group();
            findingWords(word);
        }
        showStatistics();

    }



    private static void findingWords( String word) {
        for (int i = 0; i < sortedWords.length; i++) {
            if(sortedWords[i].equals(word)){
                counterWords[i]++;
                return;
            }
        }
        sortedWords=Arrays.copyOf(sortedWords,sortedWords.length+1);
        sortedWords[sortedWords.length-1]=word;
        counterWords=Arrays.copyOf(counterWords,counterWords.length+1);
        counterWords[counterWords.length-1]=1;
    }

    private static void showStatistics() {
        for (int i = 0; i < sortedWords.length; i++) {
            System.out.printf("%s=%d%n",sortedWords[i],counterWords[i]);
            
        }
    }
}
