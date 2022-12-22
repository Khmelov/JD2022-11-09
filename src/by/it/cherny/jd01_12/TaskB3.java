package by.it.cherny.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TaskB3 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        int k = 0;
        for (int i = 0; i < 4096; i++) {
            list.add(String.valueOf(i));
        }
        System.out.println(process(list));
    }

    static String process(ArrayList<String> array){
        return getLast(array);
    }
    static String process(LinkedList<String> array){
        return getLast(array);
    }

    private static String getLast(List<String> array) {
        Boolean removeIt=false;
        while (array.size()>1){
            Iterator<String> iterator = array.iterator();
            while (iterator.hasNext()){
                iterator.next();
                if (removeIt){
                    iterator.remove();
                    removeIt=false;
                    continue;
                }
                removeIt=true;
            }
        }
        return array.get(0);
    }
}
