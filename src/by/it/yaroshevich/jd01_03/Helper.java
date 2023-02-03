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
            System.out.println("Min value in array " + min);
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
            System.out.println("Max value in array " + max);
            return max;
        } else {
            return Integer.MAX_VALUE;
        }
    }

    public static void sort(double[] array) {
        boolean checkSort;
        int countSort = array.length;
        do {
            checkSort = false;
            for (int i = 1; i < countSort; i++) {
                if (array[i] < array[i - 1]) {
                    double temporaryValue = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temporaryValue;
                    checkSort = true;
                }
            }
            countSort--;
        } while (checkSort);
        InOut.printArray(array);
    }

    static double[] multiply(double[][] matrix, double[] vector) {
        double[] result = new double[matrix.length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                result[i] += matrix[i][j] * vector[j];
            }
            System.out.println(result[i] + " ");
        }
        return result;
    }

    static double[][] multiply(double[][] matrixLeft, double[][] matrixRight) {
        double[][] result = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int l = 0; l < matrixRight.length; l++) {
                    result[i][j] += matrixLeft[i][l] * matrixRight[l][j];
                    System.out.println(result[i][j] + " ");
                }
            }
        }
        return result;
    }
}

