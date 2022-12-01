package by.it.cherny.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("\s");
        String text = Poem.text;
        String[] splitted = text.split("\n");
        int maxWidth = 0;
        for (int i = 0; i < splitted.length; i++) {
            if (splitted[i].length()>maxWidth){
                maxWidth = splitted[i].length();
            }
        }
        System.out.println("max width "+maxWidth);
        for (int i = 0; i < splitted.length; i++) {
            StringBuilder string = new StringBuilder(splitted[i]);
            int difference = maxWidth-splitted[i].length();
            Matcher matcher = pattern.matcher(string);
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
                    if (string.length()!=maxWidth){
                        int currentId = matcherIds[k]+j*k;
                        string.replace(currentId,currentId+1,"  ");
                    } else {
                        isTrue = true;
                    }
                }
                j++;
            }
            count=0;
            System.out.println(string);
        }
    }
}
