package by.it.samatokhin.jd01_12;

import java.util.*;

public class TaskA2 {
    public static void main(String[] args) {
        List<Integer> ListA = Arrays.asList(1, 2, 3, 4, 3, 2, 4, 5, 6, 6, 6, 3, 1);
        List<Integer> ListB = Arrays.asList(9, 9, 9, 8, 6, 7, 7, 6, 5, 8, 9, 8, 8);
        Set<Integer> setA = new TreeSet<>(ListA);
        Set<Integer> setB = new TreeSet<>(ListB);
        System.out.printf("setA=%s%n", setA);
        System.out.printf("setB=%s%n", setB);
        Set<Integer> union = getUnion(setA, setB);
        System.out.printf("union=%s%n", union);
        Set<Integer> cross = getCross(setA, setB);
        System.out.printf("cross=%s%n", cross);
    }

    private static Set<Integer> getCross(Set<Integer> setA, Set<Integer> setB) {
        Set<Integer> result = new HashSet<>(setA);
        result.removeIf(integer -> !setB.contains(integer));
        return result;
    }

    private static Set<Integer> getUnion(Set<Integer> setA, Set<Integer> setB) {
        Set<Integer> result = new HashSet<>(setA);
        result.addAll(setB);
        return result;
    }
}
