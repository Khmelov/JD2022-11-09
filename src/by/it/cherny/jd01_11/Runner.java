package by.it.cherny.jd01_11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Runner {
    public static void main(String[] args) {
        Set<String> list = new SetC<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("three");
        list.add("four");
        list.add("five");
        System.out.println(list+" array");
        list.remove(3);
        System.out.println(list+" remove");
//        System.out.println(list.get(1)+" get");
//        list.set(1,"seven");
        System.out.println(list+" set");
        list.add("2");
        System.out.println(list+" add pos");
        HashSet<String> added = new HashSet<>();
        added.add("null");
        added.add("null");
        added.add("1000");
        added.add("");
        added.add("2");
        added.add("-31");
        added.add("100");
        System.out.println(list.addAll(added));
        System.out.println(list);
//
//        list.addAll(added);
//        System.out.println(list);
    }
}
