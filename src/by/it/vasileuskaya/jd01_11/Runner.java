package by.it.vasileuskaya.jd01_11;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> list = new ListA<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        System.out.println("Default List: " + list);
        System.out.println(list.remove(2));
        System.out.println("Remove index 2 from list: " + list);
        System.out.println(list.get(2));


        List<String> listB = new ListB<>();
        listB.add("red");
        listB.add("pink");
        listB.add("green");
        listB.add("yellow");
        listB.add("black");
        System.out.println(listB);

        listB.add(2, "white");
        System.out.println(listB);
        System.out.println("--------");
        System.out.println(listB.set(3, "violet"));
        System.out.println(listB);

        List<String> listC = new ListB<>();
        listC.add("plate");
        listC.add("fork");
        listC.add("knife");
        System.out.println(listC);
        System.out.println(listB.size());
        listB.addAll(listC);
        System.out.println("Array 2 in 1: " + listB);
    }

}
