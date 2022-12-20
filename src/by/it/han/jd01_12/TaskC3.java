package by.it.han.jd01_12;

import java.util.*;

public class TaskC3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        System.out.println(isCorrect(next));
    }

    private static boolean isCorrect(String str) {
        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');
        Deque<Character> deque = new LinkedList<>();
        for (char c : str.toCharArray()) {
            if (map.containsValue(c)) {
                deque.push(c);
            } else if (map.containsKey(c)) {
                if (deque.isEmpty() || deque.pop() != map.get(c)) {
                    return false;
                }
            }
        }
        return deque.isEmpty();
    }
}
