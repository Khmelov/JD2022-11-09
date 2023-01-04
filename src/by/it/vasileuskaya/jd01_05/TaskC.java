package by.it.vasileuskaya.jd01_05;

import java.util.Arrays;

import static java.lang.Math.*;

public class TaskC {

    public static final String NAME_FIRST_MASSIVE = "Massive A <index to rows>";
    public static final String NAME_RESULT_MASSIVE = "Massive B <index to cols>";
    public static final String FIRST_ROW = "╔═══════════╦═══════════╦═══════════╦═══════════╦═══════════╗";
    public static final String MIDDLE_ROW = "╠═══════════╬═══════════╬═══════════╬═══════════╬═══════════╣";
    public static final String LAST_ROW = "╚═══════════╩═══════════╩═══════════╩═══════════╩═══════════╝";
    public static final String SEPARATOR = "║";

    public static void main(String[] args) {

        taskC1();
        taskC2();
    }

    private static void taskC2() {
        int[] arrayA = createArrayA();
        printArrayA(arrayA);
        int[] arrayB = createArrayB(arrayA);
        printArrayB(arrayB);
    }

    private static void printArrayB(int[] array) {
        System.out.println(NAME_RESULT_MASSIVE);
        System.out.println(FIRST_ROW);
        int countCols = 5;
        int countRows = 0;
        if (array.length > 0) {
            countRows = array.length / 5;
        }
        for (int i = 0, j = 0; i < array.length; i += countRows, j++) {
            countCols++;
            System.out.printf(SEPARATOR + " B[%2d]=%d ", i, array[i]);
            if (countCols == 5) {
                System.out.print(SEPARATOR + "\n");
                System.out.println(MIDDLE_ROW);
                countCols = 0;
            }
        }
        System.out.println("\n" + LAST_ROW);
    }

    private static int[] createArrayB(int[] array) {

        int countElementsToArray = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] * 0.1 > i) {
                countElementsToArray++;
            }
        }
        int[] arrayB = new int[countElementsToArray];
        for (int i = 0; i < array.length; i++) {
            if (array[i] * 0.1 > i) {
                Arrays.fill(arrayB, array[i]);
            }
        }
        return Arrays.stream(arrayB).sorted().toArray();
    }

    private static int[] createArrayA() {
        int[] arrayA = new int[31];
        for (int i = 0; i < arrayA.length; i++) {
            arrayA[i] = (int) (random() * 348) + 103;
        }
        return arrayA;
    }

    private static void printArrayA(int[] array) {
        System.out.println(NAME_FIRST_MASSIVE);
        System.out.println(FIRST_ROW);
        int countCols = 0;
        for (int i = 0; i < array.length; i++) {
            countCols++;
            System.out.printf(SEPARATOR + " A[%2d]=%d ", i, array[i]);
            if (countCols == 5) {
                System.out.print(SEPARATOR + "\n");
                System.out.println(MIDDLE_ROW);
                countCols = 0;
            }
        }
        System.out.println("\n" + LAST_ROW);
    }

    static void taskC1() {
        int countOfElementsX = (int) ((random() * 21) + 20);
        double delta = (9 - 5.33) / (countOfElementsX - 1);
        System.out.println("The first array A with count of elements " + countOfElementsX + ":");
        double[] arrayZ = getArrayOfFunctionValues(countOfElementsX, delta);
        printArray(arrayZ);
        int countOfElements = findLengthSecondArray(arrayZ);
        double[] arrayB = getSecondArray(countOfElements, arrayZ);
        double geometricMean = findGeometricMean(arrayB, countOfElements);
        System.out.println();
        System.out.println("The second array B with count of elements " + countOfElements + ":");
        printArray(arrayB);
        System.out.println();
        System.out.println("Geometric mean of array B:" + geometricMean);
    }

    private static double[] getArrayOfFunctionValues(int countOfElementsX, double delta) {
        double[] arrayZ = new double[countOfElementsX];
        for (double i = 0, x = 5.33; x <= 9.0; x += delta, i++) {
            arrayZ[(int) i] = cbrt(x * x + 4.5);
        }
        return arrayZ;
    }

    private static void printArray(double[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i % 5 == 0) {
                System.out.printf("%nA[%-2d]=%-10.7f", i, array[i]);
            } else {
                System.out.printf("A[%-2d]=%-10.7f ", i, array[i]);
            }
        }
    }

    private static int findLengthSecondArray(double[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 3.5) {
                count++;
            }
        }
        return count;
    }

    private static double[] getSecondArray(int countOfElements, double[] array) {
        int index = 0;
        double[] arrayB = new double[countOfElements];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 3.5) {
                arrayB[index] = array[i];
                index++;
            }
        }
        return arrayB;
    }

    private static double findGeometricMean(double[] array, int countOfElements) {
        double proizvedenie = 1;
        for (int i = 0; i < array.length; i++) {
            proizvedenie *= array[i];
        }
        return pow(proizvedenie, 1.0 / countOfElements);
    }
}




