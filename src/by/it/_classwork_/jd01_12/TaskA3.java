package by.it._classwork_.jd01_12;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int positionZero = 0;
        // 1 -2 3 -4 0 -3 5 7 0 -3 1 end
        // 1 3 5 7 1 0 0 -2 -4 -3 -3
        for (; ; ) {
            String value = scanner.next();
            if (value.equals("end")) {
                break;
            }
            Integer integer = Integer.valueOf(value);
            if (integer > 0) {
                list.add(positionZero++, integer);
            } else if (integer < 0) {
                list.add(integer);
            } else {
                list.add(positionZero, integer);
            }
        }
        System.out.println(list);
    }
}
