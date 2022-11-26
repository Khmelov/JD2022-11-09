package by.it.boycova.jd01_03;/*
package by.it.boycova.jd01_03;

public class Helper {

    public static double findMin(double[] array) {
        double min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    public static double findMax(double[] array) {
        double max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public static void sort(double[] array) {
        boolean unsorted = true;
        double max;
        while (unsorted) {
            unsorted = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    max = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = max;
                    unsorted = true;
                }
            }
        }
    }

    public static void multiply(double[][] matrix, double[] vector) {
        int x=0;
        for (int i = 0; i < matrix[0].length;) {
            for (int j = 0; j < matrix.length; j++) {
                vector[x]= matrix[0][j];
                x++;
            }
        }
        double[][] result=new double[][];
        double res= vector*matrix;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if(j==x){
                    vector[x]*matrix[i][j];
                }
            }
        }
    }

}



 */