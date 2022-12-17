package by.it.han.jd01_12;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TaskA2 {

    public static void main(String[] args) {
        Set<Integer> a = new HashSet<>();
        Set<Integer> b = new TreeSet<>();
        System.out.println(getCross(a, b));
        System.out.println(getUnion(a, b));
    }

    private static Set<Integer> getCross(Set<Integer> a, Set<Integer> b) {
        Set<Integer> res = new HashSet<>(a);
        res.retainAll(b);
        return res;
    }

    private static Set<Integer> getUnion(Set<Integer> a, Set<Integer> b) {
        Set<Integer> res = new HashSet<>(a);
        res.addAll(b);
        return res;
    }
}
