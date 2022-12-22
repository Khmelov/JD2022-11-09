package by.it.han.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TaskB2 {

    private static boolean isCrossed = false;

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Nik");
        list.add("Nika");
        list.add("Marina");
        list.add("Seva");
        list.add("Ivan");
        LinkedList<String> list1 = new LinkedList<>();
        list1.add("Nik");
        list1.add("Nika");
        list1.add("Marina");
        list1.add("Seva");
        list1.add("Ivan");
        System.out.printf("%s=%s", "ArrayList", process(list));
        System.out.printf("%s=%s", "ArrayList", process(list1));
    }

    private static String process(ArrayList<String> peoples) {
        ArrayList<String> result = new ArrayList<>(peoples);
        return getLast(result);
    }

    private static String process(LinkedList<String> peoples) {
        LinkedList<String> result = new LinkedList<>(peoples);
        return getLast(result);
    }

    private static String getLast(List<String> result) {
        int remained = result.size();
        while (remained > 1) {
            Iterator<String> iterator = result.iterator();
            while (iterator.hasNext() && remained > 1) {
                iterator.next();
                if (isCrossed) {
                    isCrossed = false;
                    iterator.remove();
                    remained--;
                    continue;
                }
                isCrossed = true;
            }
        }
        return result.get(0);
    }
}
