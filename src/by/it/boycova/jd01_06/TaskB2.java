package by.it.boycova.jd01_06;


import java.util.Arrays;
import java.util.Comparator;

public class TaskB2 {
    public static void main(String[] args) {
        String textReplaced=Poem.text.replaceAll("\\.{3}", " ").replaceAll("[-,:\\n]"," ").replaceAll("( {2,})"," ");
        String[] textSplitted=textReplaced.split("\\.");
        String[] textTrimmed=new String[textSplitted.length];
        for (int i = 0; i < textSplitted.length; i++) {
            textTrimmed[i]=textSplitted[i].trim();
        }
        boolean unsorted = true;
        String value;
        while (unsorted) {
            unsorted = false;
            for (int i = 0; i < textTrimmed.length - 1; i++) {
                if (textTrimmed[i].length() > textTrimmed[i + 1].length()) {
                    value = textTrimmed[i];
                    textTrimmed[i] = textTrimmed[i + 1];
                    textTrimmed[i + 1] = value;
                    unsorted = true;
                }
            }
        }
        for (int i = 0; i < textTrimmed.length; i++) {
            System.out.println(textTrimmed[i]);
        }


    }

}
