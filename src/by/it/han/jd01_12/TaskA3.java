package by.it.han.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {

    private static int nullIndex = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        while (true) {
            String input = scanner.next();
            if (input.equalsIgnoreCase("end")) {
                break;
            }
            int number = Integer.parseInt(input);
            if (number > 0) {
                numbers.add(nullIndex++, number);
            } else if (number < 0) {
                numbers.add(number);
            } else {
                numbers.add(nullIndex, number);
            }
        }
        System.out.println(numbers);
    }
}
