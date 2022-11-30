package by.it.yaroshevich.jd01_03;


public class Helper {
    public static double findMin(double[] array) {
        if (array.length > 0) {
            double min = array[0];
            for (double num : array) {
                if (num < min) {
                    min = num;
                }
            }
            return min;
        } else {
            return Integer.MIN_VALUE;
        }
    }

    public static double findMax(double[] array) {
        if (array.length > 0) {
            double max = array[0];
            for (double num : array) {
                if (num > max) {
                    max = num;
                }
            }
            return max;
        } else {
            return Integer.MAX_VALUE;
        }
    }

    public static void sort(double[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (array[j - 1] > array[j]) {
                    double swap = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = swap;
                }
            }
        }
    }
/*
    static double[] multiply(double[][] matrix, double[] vector) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = j + 1;
            }
        }
        for (int i = 0; i < vector.length; i++) {
            vector[i] = i + 1;
        }
        double[] result = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < vector.length; j++)
                result[i] = result[i] + matrix[i][j] * vector[j];
        return result;
    }
}

    static double[][] multiply(double[][] matrixLeft, double[][] matrixRight) {
        double[][] result = new double[matrixLeft.length] [matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {

                }
            }

        }
        return result;
    }

 */
}

