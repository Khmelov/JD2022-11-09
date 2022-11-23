package by.it.han.jd01_04;

import by.it.han.jd01_03.Helper;
import by.it.han.jd01_03.InOut;

import java.util.Scanner;

public class TaskA {
    private static final int COLUMN_COUNT_FIRST = 5;
    private static final int COLUMN_COUNT_SECOND = 4;
    private static final String ARRAY_NAME = "V";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printMulTable();
        String input = scanner.nextLine();
        buildOneDimArray(input);
    }

    public static void printMulTable() {
        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                System.out.printf("%d*%d=%-3d", i, j, i * j);
            }
            System.out.println();
        }
    }

    public static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        double firstElement = array[0];
        double lastElement = array[array.length - 1];
        int indexFirstElement = 0;
        int indexLastElement = array.length - 1;
        InOut.printArray(array, ARRAY_NAME, COLUMN_COUNT_FIRST);
        Helper.sort(array);
        for (int i = 0; i < array.length; i++) {
            if (firstElement == array[i]) {
                indexFirstElement = i;
            }
            if (lastElement == i) {
                indexLastElement = i;
            }
        }
        InOut.printArray(array, ARRAY_NAME, COLUMN_COUNT_SECOND);
        System.out.printf("Index of first element=%d%n" +
                "Index of last element=%d", indexFirstElement, indexLastElement);
    }
}
