package by.it.vasileuskaya.jd01_05;

import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {
        taskC1();
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
        double sredneeGeometrich = pow(proizvedenie, 1.0 / countOfElements);
        return sredneeGeometrich;
    }
}




