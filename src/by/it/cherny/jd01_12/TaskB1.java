package by.it.cherny.jd01_12;

import java.util.*;

public class TaskB1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map map = new HashMap();
        List<Object> list = new LinkedList<>();
        while (scanner.hasNext()){
            String value = scanner.next();
            if (value.equals("end")) {
                break;
            }
            list.add(value.replaceAll("[^\\w-']",""));
        }
        for (int i = 0; i < list.size(); i++) {
            Object currentElem = list.get(i);
            if (!map.containsKey(currentElem)){
                int counter =0;
                for (Object o : list) {
                    if (o.equals(currentElem)){
                        counter++;
                    }
                }
//                System.out.printf("elem %s, counter %d", currentElem, counter);
                map.put(currentElem,counter);
            }
        }
        System.out.println(map);
    }
}
