package by.it.bolshakov.jd01_11;

import java.util.Collection;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> list = new ListB<>();
        list.add("one"); //0
        list.add("two");  //1
        list.add("three"); //2
        list.add("four"); //3
        list.add(1, "five"); //4
        List<String> list2 = new ListA<>();
        list2.add("one"); //0
        list2.add("two");  //1
        list2.add("three"); //2
        list2.add("four"); //3
        list2.add("five"); //4
        System.out.println(list);
        list.remove(3);
        list.remove(0);
        System.out.println(list);
        System.out.printf("element[1] = %s%n",list.get(1));
        list.addAll(list2);
        System.out.println(list);
    }
}
