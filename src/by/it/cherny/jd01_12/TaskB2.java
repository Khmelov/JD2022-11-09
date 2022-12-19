package by.it.cherny.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

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
        Iterator<String> iterator = peoples.iterator();
        int i=0;
        do {
            if (iterator.hasNext()){
                iterator.next();
                if (i%2==0 && i!=0){
                    iterator.remove();
                }
                i++;
            }else {
                iterator= peoples.iterator();
            }
        } while(peoples.size()!=1);
        return peoples.get(0);
    }
    static String process(LinkedList<String> peoples){
        int k=2;
        int size = peoples.size();
        do {
            for (int i = k; i < peoples.size(); i++) {
                peoples.remove(peoples.get(i));
            }
            if (peoples.size()%2==0){
                k=0;
            } else {
                k=1;
            }
            size = peoples.size();
        } while(peoples.size()!=1);
        return peoples.get(0);
    }
}
