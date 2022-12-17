package by.it._classwork_.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> list = new ListA<>();
        list.add("one"); //0
        list.add("two");  //1
        list.add("three"); //2
        list.add("four"); //3
        list.add("five"); //4
        System.out.println(list);
        list.remove(3);
        list.remove(0);
        System.out.println(list);
        System.out.printf("element[1] = %s%n",list.get(1));
    }
}
