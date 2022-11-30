package by.it.bolshakov.jd01_04;

import java.util.Scanner;

public class InOut {

    static double[ ] getArray(String line) {
        String[] items = line.split(" ");
        double[] numbers = new double[items.length];
        for (int i = 0; i < items.length; i++) {
            try {
                numbers[i] = Double.parseDouble(items[i]);
            } catch (NumberFormatException nfe) {
                System.out.println("Error: " + nfe.getMessage());
                System.out.println("Invalid input: " + items[i]);
            }
        }
        return numbers;
    }

    static void printArray(double[ ] array) {
        for (double number : array) {
            System.out.print(number + " ");
        }
    }

    static void printArray(double[ ] array, String name, int columnCount) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s[%d]=%-9.3f", name, i, array[i]);
            if ((i + 1)%columnCount == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String line = scanner.nextLine();
        printArray(getArray(line), "a", 1);
    }
}
