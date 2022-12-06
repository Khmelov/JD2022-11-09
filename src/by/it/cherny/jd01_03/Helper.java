package by.it.cherny.jd01_03;

import java.util.Arrays;

public class Helper {
    public static double findMax(double[] array) {
        double max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (max<array[i]){
                max = array[i];
            }
        }
        return max;
    }
    public static double findMin(double[] array) {
        double min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (min>array[i]){
                min = array[i];
            }
        }
        return min;
    }

    public static void sort(double[] array) {
        boolean isSwapped;
        int swappedArrLength = array.length-1;
        do {
            isSwapped = false;
            for (int i = 0; i < swappedArrLength; i++) {
                if (array[i] > array[i + 1]) {
                    double buffer = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = buffer;
                    isSwapped = true;
                }
            }
            swappedArrLength--;
        } while (isSwapped);
        System.out.println(Arrays.toString(array));
    }

    public static double[] mul(double[][] matrix, double[] vector){
//        double[] result=new double[matrix[0].length];
//        for (int i = 0; i < vector.length; i++) {
//            for (int j = 0; j < matrix[i].length; j++) {
//                result[i] += matrix[i][j] * vector[i];
//            }
//        }
        int m = matrix.length;
        int n = matrix[0].length;
        if (vector.length != n) throw new RuntimeException("Illegal matrix dimensions.");
        double[] y = new double[m];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                y[i] += matrix[i][j] * vector[j];
        return y;
//        return result;
    }

    public static double[][] mul(double[][] matrixLeft, double[][] matrixRight){
        double[][] result = new double[matrixLeft.length][matrixRight[0].length];

        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    result[i][j] += matrixLeft[i][k] * matrixRight[k][j];
                }
            }
        }
        return result;
    }
}
