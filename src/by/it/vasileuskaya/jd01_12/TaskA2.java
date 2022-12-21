package by.it.vasileuskaya.jd01_12;

import java.util.*;

public class TaskA2 {
    public static void main(String[] args) {
        List<Integer> listA = Arrays.asList(1, 2, 3, 4, 5, 6, 6, 6, 6, 3, 4, 1);
        List<Integer> listB = Arrays.asList(9, 9, 8, 7, 8, 6, 5, 7, 6, 5, 9, 8);
        Set<Integer> a = new HashSet<>(listA);
        Set<Integer> b = new TreeSet<>(listB);
        System.out.printf("setA=%s%n", a);
        System.out.printf("setB=%s%n", b);
        Set<Integer> union = getUnion(a, b);
        System.out.printf("union=%s%n", union);
        Set<Integer> cross = getCross(a, b);
        System.out.printf("cross=%s%n", cross);
    }

    private static Set<Integer> getUnion(Set<Integer> a, Set<Integer> b) {
        Set<Integer> result = new HashSet<>(a);
        result.addAll(b);
        return result;
    }

    private static Set<Integer> getCross(Set<Integer> a, Set<Integer> b) {
        Set<Integer> result = new HashSet<>(a);
        result.retainAll(b);
        return result;
    }

}

