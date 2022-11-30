package by.it.han.jd01_04;

import by.it.han.jd01_03.InOut;

import java.util.Scanner;

public class TaskC {
    private static final int COLUMN_COUNT_FIRST = 5;
    private static final int COLUMN_COUNT_SECOND = 4;
    private static final String ARRAY_NAME = "V";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        buildOneDimArray(input);
    }

    public static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        double firstElement = array[0];
        double lastElement = array[array.length - 1];
        InOut.printArray(array, ARRAY_NAME, COLUMN_COUNT_FIRST);
        InOut.printArray(mergeSort(array), ARRAY_NAME, COLUMN_COUNT_SECOND);
        System.out.printf("Index of first element=%d%n" +
                "Index of last element=%d%n", binarySearch(array, firstElement), binarySearch(array, lastElement));
    }

    public static double[] mergeSort(double[] array) {
        if (array.length < 2) return array;
        int mid = array.length / 2;
        double[] left = new double[mid];
        double[] right = new double[array.length - mid];
        System.arraycopy(array, 0, left, 0, mid);
        System.arraycopy(array, mid, right, 0, array.length - mid);
        mergeSort(left);
        mergeSort(right);
        merge(array, left, right);
        return array;
    }

    public static void merge(double[] array, double[] left, double[] right) {
        int k = 0;
        int i = 0;
        int j = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        while (i < left.length) {
            array[k++] = left[i++];
        }

        while (j < right.length) {
            array[k++] = right[j++];
        }
    }

    public static int binarySearch(double[] array, double value) {
        int firstIndex = 0;
        int lastIndex = array.length - 1;
        int middleIndex = (lastIndex + firstIndex) / 2;
        while (firstIndex <= lastIndex) {
            middleIndex = (firstIndex + lastIndex) / 2;
            if (array[middleIndex] == value) {
                break;
            } else if (array[middleIndex] < value) {
                firstIndex = middleIndex + 1;
            } else {
                lastIndex = middleIndex - 1;
            }
        }
        return middleIndex;
    }
}
