package by.it.cherny.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TaskB2 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
        list.add("10");
        list.add("11");
        list.add("12");
        System.out.println(process(list));

    }

    static String process(ArrayList<String> peoples){
        return getLast(peoples);
    }
    static String process(LinkedList<String> peoples){
        return getLast(peoples);
    }

    private static String getLast(List<String> peoples) {
        Boolean removeIt=false;
        while (peoples.size()>1){
            Iterator<String> iterator = peoples.iterator();
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
        return peoples.get(0);
    }
}
