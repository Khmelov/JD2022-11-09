package by.it.bogumil.jd01_03;

import java.util.Arrays;

public class InOut {
    public static double[] getArray(String line) {

        return Arrays.stream(line.split(" ")).mapToDouble(Double::parseDouble).toArray();
    }

    public static void printArray(double[] array) {

        for (double val : array) {
            System.out.print(val + " ");
        }

        System.out.println();
    }

    public static void printArray(double[] array, String name, int columnCount) {

        for (int i = 0; i < array.length; i++) {
            System.out.printf(" %s[%d]=%-10.2f ", name, i, array[i]);

            if ((i + 1) % columnCount == 0 || i + 1 == array.length) {
                System.out.println();
            }
        }
    }
}

