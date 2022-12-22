package by.it.vasileuskaya.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB2 {
    public static void main(String[] args) {
        ArrayList<String> peoples = new ArrayList<>();
        peoples.add("Pasha");
        peoples.add("Masha");
        peoples.add("Dasha");
        peoples.add("Natasha");
        peoples.add("Mark");
        peoples.add("Misha");
        peoples.add("Katya");
        peoples.add("Alena");
        peoples.add("Jeremy");
        peoples.add("Ira");

        LinkedList<String> peoples2 = new LinkedList<>();
        peoples2.add("Pasha");
        peoples2.add("Masha");
        peoples2.add("Dasha");
        peoples2.add("Natasha");
        peoples2.add("Mark");
        peoples2.add("Misha");
        peoples2.add("Katya");
        peoples2.add("Alena");
        peoples2.add("Jeremy");
        peoples2.add("Ira");
        process(peoples);
        process(peoples2);
    }

    static String process(ArrayList<String> peoples) {
        Iterator<String> iterator = peoples.iterator();
        int step = 2;
        int count = 0;
        while (peoples.size() > 1) {
            if (iterator.hasNext()) {
                iterator.next();
                count++;
                if (count == step) {
                    iterator.remove();
                    count = 0;
                    System.out.println(peoples);
                }
            } else {
                iterator = peoples.iterator();
            }
        }
        System.out.println("The last name: " + peoples);
        return peoples.get(0);
    }

    static String process(LinkedList<String> peoples2) {
        Iterator<String> iterator = peoples2.iterator();
        int step = 2;
        int count = 0;
        while (peoples2.size() > 1) {
            if (iterator.hasNext()) {
                iterator.next();
                count++;
                if (count == step) {
                    iterator.remove();
                    count = 0;
                    System.out.println(peoples2);
                }
            } else {
                iterator = peoples2.iterator();
            }
        }
        System.out.println("The last name: " + peoples2);
        return peoples2.get(0);

    }

}
