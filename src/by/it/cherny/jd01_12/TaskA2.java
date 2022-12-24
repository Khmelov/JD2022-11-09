package by.it.cherny.jd01_12;

import java.util.*;

public class TaskA2 {
    public static void main(String[] args) {
        List<Integer> listA = Arrays.asList(1, 2, 2, 3, 3, 4, 5, 6, 6, 6, 3, 1);
        List<Integer> listB = Arrays.asList(9, 9, 7, 8, 8, 7, 6, 5, 5, 4, 4, 5, 6, 7, 8, 9, 9, 32);
        Set<Integer> setA = new HashSet<>(listA);
        Set<Integer> setB = new TreeSet<>(listB);
        System.out.printf("setA=%s%n", setA);
        System.out.printf("setB=%s%n", setB);
        Set<Integer> union = getUnion(setA, setB);
        System.out.printf("union=%s%n", union);
        Set<Integer> cross = getCross(setA, setB);
        System.out.printf("cross=%s%n", cross);

    }

    private static Set<Integer> getCross(Set<Integer> setA, Set<Integer> setB) {
        Set<Integer> result=new HashSet<>(setA);
        result.removeIf(integer -> !setB.contains(integer));
        return result;
    }

    private static Set<Integer> getUnion(Set<Integer> setA, Set<Integer> setB) {
        Set<Integer> result=new HashSet<>(setA);
        result.addAll(setB);
        return result;
    }
}
