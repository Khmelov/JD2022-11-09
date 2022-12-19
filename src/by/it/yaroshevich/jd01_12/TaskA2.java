package by.it.yaroshevich.jd01_12;

import java.util.*;

public class TaskA2 {
    public static void main(String[] args) {
        List<Integer> ListA = Arrays.asList(1, 2, 3, 9);
        List<Integer> ListB = Arrays.asList(4, 2, 2, 1);
        Set<Integer> setA = new HashSet<>(ListA);
        Set<Integer> setB = new TreeSet<>(ListB);

        System.out.println(setA);
        System.out.println(setB);

        Set<Integer>union=getUnion(setA, setB);
        System.out.println(union);

        Set<Integer>cross=getCross(setA, setB);
        System.out.println(cross);

    }

    private static Set<Integer> getCross(Set<Integer> setA, Set<Integer> setB) {
        Set<Integer> result = new HashSet<>(setA);
        Iterator<Integer> iterator = result.iterator();
        while (iterator.hasNext()){
            Integer next = iterator.next();
            if (!setB.contains(next)){
                iterator.remove();
            }
        }
        return result;
    }

    private static Set<Integer> getUnion(Set<Integer> setA, Set<Integer> setB) {
        Set<Integer> result = new HashSet<>(setA);
        result.addAll(setB);
        return result;
    }
}
