package by.it.han.jd01_13;

import java.util.Scanner;

import static by.it.han.jd01_13.TaskA.printException;

public class TaskB {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        while (true) {
            String line = scanner.next();
            if (line.equals("END")) {
                break;
            }
            double number = 0;
            double result = 0;
            try {
                number = Double.parseDouble(line);
                sum += number;
                result = Math.sqrt(sum);
                if (sum < 0) {
                    throw new ArithmeticException();
                }
            } catch (RuntimeException e) {
                printException(e, TaskB.class);
            }
            System.out.println(number);
            System.out.println(result);
        }
    }
}
