package by.it.han.jd01_12;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class TaskC1 {

    private static Integer count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, String> map = getMap(scanner);
        System.out.println(map);
        Map<Integer, String> uniqueMap = getUniqueMap(map);
        System.out.println(uniqueMap);
    }

    private static Map<Integer, String> getUniqueMap(Map<Integer, String> map) {
        Map<Integer, String> uniqueMap = new TreeMap<>();
        map.forEach((k, v) -> {
            if (!uniqueMap.containsValue(v)) {
                uniqueMap.put(k, v);
            }
        });
        return uniqueMap;
    }

    private static Map<Integer, String> getMap(Scanner scanner) {
        Map<Integer, String> map = new TreeMap<>();
        while (true) {
            String s = scanner.next();
            if (s.equalsIgnoreCase("end")) {
                break;
            }
            map.put(count, s);
            count++;
        }
        return map;
    }
}
