package by.it.han.jd01_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskC {

    private static Scanner scanner;

    public static void main(String[] args) throws InterruptedException {
        scanner = new Scanner(System.in);
        readData();
    }

    private static void readData() throws InterruptedException {
        List<Double> numbers = new ArrayList<>();
        int countException = 0;
        while (true) {
            try {
                String number = scanner.next();
                numbers.add(Double.valueOf(number));
            } catch (RuntimeException e) {
                countException++;
                Thread.sleep(100);
                for (int i = numbers.size() - 1; i >= 0; i--) {
                    System.out.print(numbers.get(i) + " ");
                }
                System.out.println();
            }
            if (countException > 4) {
                throw new RuntimeException();
            }
        }
    }
}
