package by.it.bogumil.jd01_04;

import by.it.bogumil.jd01_03.Helper;
import by.it.bogumil.jd01_03.InOut;

import java.util.Scanner;

public class TaskA {

    private static final int COLUMN_COUNT_FIRST = 5;
    private static final int COLUMN_COUNT_SECOND = 4;
    private static final String ARRAY_NAME = "V";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        buildOneDimArray(input);
        printMulTable();
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
        double first = array[0];
        double last = array[array.length - 1];

        int indexFirst = 0;
        int indexLast = array.length - 1;

        InOut.printArray(array, ARRAY_NAME, COLUMN_COUNT_FIRST);
        Helper.sort(array);

        for (int i = 0; i < array.length; i++) {
            if (first == array[i]) {
                indexFirst = i;
            }
            if (last == i) {
                indexLast = i;
            }
        }

        InOut.printArray(array, ARRAY_NAME, COLUMN_COUNT_SECOND);
        System.out.printf("Index of first element=%d%n" + "Index of last element=%d", indexFirst, indexLast);
    }
}

