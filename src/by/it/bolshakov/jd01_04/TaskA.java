package by.it.bolshakov.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

import static by.it.bolshakov.jd01_04.InOut.getArray;
import static by.it.bolshakov.jd01_04.InOut.printArray;

public class TaskA {

    static void printMulTable() {
        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                System.out.printf("%1d*%1d=%-2d ", i, j, i*j);
            }
            System.out.println();
        }
    }

    static void buildOneDimArray(String line) {
        double[] numbers = getArray(line);
        printArray(numbers,"V", 5);
        double first = numbers[0];
        double last = numbers[numbers.length-1];
        Arrays.sort(numbers);
        printArray(numbers,"V", 4);
        System.out.println("Index of first element=" + Arrays.binarySearch(numbers, first));
        System.out.println("Index of last element=" + Arrays.binarySearch(numbers, last));
    }

    public static void main(String[] args) {
        printMulTable();
        Scanner scanner=new Scanner(System.in);
        String line = scanner.nextLine();
        buildOneDimArray(line);
    }
}
