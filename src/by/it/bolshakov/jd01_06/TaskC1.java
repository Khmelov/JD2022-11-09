package by.it.bolshakov.jd01_06;

import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {

    public static void main(String[] args) {
        Pattern whitespaces = Pattern.compile("\s");
        String[] sentences = Poem.text.split("\n");
        int maxWidth = Arrays.stream(sentences).max(Comparator.comparingInt(String::length)).get().length();
        for (int i = 0; i < sentences.length; i++) {
            StringBuilder sentence = new StringBuilder(sentences[i]);
            Matcher matcher = whitespaces.matcher(sentence);
            int count = 0;
            int[] matcherIds = new int[count];
            while (matcher.find()){
                matcherIds= Arrays.copyOf(matcherIds, matcherIds.length+1);
                matcherIds[count]=matcher.start();
                count++;
            }
            boolean isTrue = false;
            int j = 1;
            while (!isTrue){
                for (int k = 0; k < matcherIds.length; k++) {
                    if (sentence.length()!=maxWidth){
                        int currentId = matcherIds[k]+j*k;
                        sentence.replace(currentId,currentId+1,"  ");
                    } else {
                        isTrue = true;
                    }
                }
                j++;
            }
            count=0;
            System.out.println(sentence);
        }
    }
}
