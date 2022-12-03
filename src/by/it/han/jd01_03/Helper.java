package by.it.han.jd01_03;

public class Helper {

    public static double findMin(double[] array) {
        double min = Double.MAX_VALUE;
        for (double val : array) {
            if (val < min) {
                min = val;
            }
        }
        return min;
    }

    public static double findMax(double[] array) {
        double max = Double.MIN_VALUE;
        for (double val : array) {
            if (val > max) {
                max = val;
            }
        }
        return max;
    }

    public static void sort(double[] array) {
        for (int i = array.length - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    double shift = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = shift;
                }
            }
        }
    }

    public static double[] multiply(double[][] matrix, double[] vector) {
        double[] result = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                result[i] += matrix[i][j] * vector[j];
            }
        }
        return result;
    }

    public static double[][] multiply(double[][] matrixLeft, double[][] matrixRight) {
        int m = matrixRight[0].length;
        int n = matrixLeft.length;
        int o = matrixRight.length;
        double[][] result = new double[m][n];
        if (m == n) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < o; k++) {
                        result[i][j] += matrixLeft[i][k] * matrixRight[k][j];
                    }
                }
            }
            return result;
        } else {
            System.out.println("Эти матрицы невозможно перемножить");
            return new double[1][1];
        }
    }
}
