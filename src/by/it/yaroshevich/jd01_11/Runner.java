package by.it.yaroshevich.jd01_11;

import by.it.bolshakov.jd01_11.ListA;
import by.it.bolshakov.jd01_11.ListB;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> list = new ListB<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add(1, "five");
        List<String> list2 = new ListA<>();
        list2.add("one");
        list2.add("two");
        list2.add("three");
        list2.add("four");
        list2.add("five");
        System.out.println(list);
        list.remove(3);
        list.remove(0);
        System.out.println(list);
        System.out.printf("element[1] = %s%n",list.get(1));
        list.addAll(list2);
        System.out.println(list);
    }
}