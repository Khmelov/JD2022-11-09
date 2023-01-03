package by.it.bolshakov.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.concurrent.ThreadLocalRandom;

public class TaskB3 {
    static String process(ArrayList<String> peoples) {
        int counter = 0;
        while (peoples.size()!=1) {
            Iterator<String> iterator = peoples.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (counter % 2 == 1) {
                    iterator.remove();
                    counter=0;
                } else
                    counter++;
            }
        }
        return peoples.get(0);
    }

    static String process(LinkedList<String> peoples){
        int counter = 0;
        while (peoples.size()!=1) {
            ListIterator iterator = peoples.listIterator(0);
            while (iterator.hasNext()) {
                iterator.next();
                if (counter % 2 == 1) {
                    iterator.remove();
                    counter=0;
                } else
                    counter++;
            }
        }
        return peoples.get(0);
    }

    public static void main(String[] args) {
        ArrayList<String> people = new ArrayList<>();
        LinkedList<String> peopleL = new LinkedList<>();
        int size = 4096;
        for (int i = 0; i < size; i++) {
            people.add(String.valueOf(i));
            peopleL.add(String.valueOf(i));
        }
        System.out.println(people);
        System.out.println(peopleL);
        System.out.println(process(people));
        System.out.println(process(peopleL));
    }

}
