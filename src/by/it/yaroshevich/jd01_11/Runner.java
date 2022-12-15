package by.it.yaroshevich.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> list = new ListA<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        System.out.println(list);
        list.remove(3);
        System.out.println(list);
        System.out.printf("element[1] = %s%n",list.get(1));
    }
}
