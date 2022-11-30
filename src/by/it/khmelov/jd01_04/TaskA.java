package by.it.khmelov.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskA {

    public static final String ARRAY_NAME = "V";
    public static final int COLUMN_COUNT = 5;
    public static final int COLUMN_COUNT_SECOND = 4;

    public static void main(String[] args) {
        printMulTable();
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        buildOneDimArray(line);
    }

    private static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        InOut.printArray(array,ARRAY_NAME, COLUMN_COUNT);
        double firstElement = array[0];
        double lastElement = array[array.length - 1];
        Helper.sort(array);
        InOut.printArray(array,ARRAY_NAME, COLUMN_COUNT_SECOND);
        int indexFirstElement = Arrays.binarySearch(array,firstElement);
        int indexLastElement = Arrays.binarySearch(array,lastElement);
        System.out.printf("Index of first element=%d%n" +
                "Index of last element=%d%n",indexFirstElement,indexLastElement);
    }

    private static void printMulTable() {
        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                System.out.printf("%d*%d=%-3d",i,j,i*j);
            }
            System.out.println();
        }
    }
}
