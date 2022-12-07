package by.it.bogumil.jd01_04;

import by.it.bogumil.jd01_03.InOut;

import java.util.Scanner;

public class TaskC {
    private static final int COLUMN_COUNT_FIRST = 5;
    private static final int COLUMN_COUNT_SECOND = 4;
    private static final String ARRAY_NAME = "V";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String put = scanner.nextLine();
        buildOneDimArray(put);
    }

    public static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        double firstElements = array[0];
        double lastElements = array[array.length - 1];
        InOut.printArray(array, ARRAY_NAME, COLUMN_COUNT_FIRST);
        InOut.printArray(mergeSort(array), ARRAY_NAME, COLUMN_COUNT_SECOND);
        System.out.printf("Index of first element=%d%n" +
                "Index of last element=%d%n", binarySearch(array, firstElements), binarySearch(array, lastElements));
    }

    public static double[] mergeSort(double[] array) {

        if (array.length < 2) return array;

        int rad = array.length / 2;
        double[] left = new double[rad];
        double[] right = new double[array.length - rad];

        System.arraycopy(array, 0, left, 0, rad);
        System.arraycopy(array, rad, right, 0, array.length - rad);
        mergeSort(left);
        mergeSort(right);
        merge(array, left, right);

        return array;
    }

    public static void merge(double[] array, double[] left, double[] right) {

        int i = 0;
        int j = 0;
        int k = 0;

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
        int firIndex = 0;
        int lastIndex = array.length - 1;
        int middIndex = (lastIndex + firIndex) / 2;
        while (firIndex <= lastIndex) {
            middIndex = (firIndex + lastIndex) / 2;
            if (array[middIndex] == value) {
                break;
            } else if (array[middIndex] < value) {
                firIndex = middIndex + 1;
            } else {
                lastIndex = middIndex - 1;
            }
        }
        return middIndex;
    }
}

