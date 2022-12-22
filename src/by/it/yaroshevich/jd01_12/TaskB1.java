package by.it.yaroshevich.jd01_12;

import java.util.HashMap;
import java.util.Scanner;

public class TaskB1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String,Integer> keyValue = new HashMap<String,Integer>();

        for(;;) {
            String value = scanner.next();
            if (value.equals("end")) {
                break;
            }
            String [] words = value.replaceAll("[()?:!.,;{}\"]+", "").split("\\s+");

            for (int i=0; i<= words.length-1; i++) {

                if (keyValue.containsKey(words[i])) {
                    int counter = keyValue.get(words[i]);
                    keyValue.put(words[i], counter+1);

                } else {
                    keyValue.put(words[i], 1);
                }
            }
        }
        System.out.println(keyValue);
    }
}

