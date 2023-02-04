package by.it.bolshakov.jd01_03;

import java.util.Scanner;

import static by.it.bolshakov.jd01_03.InOut.getArray;

public class Helper {

    static double findMin(double[ ] array) {
        sort(array);
        return array[0];
    }

    static double findMax(double[ ] array) {
        sort(array);
        return array[array.length-1];
    }

    static void sort(double[ ] array) {
        for (int i=0;i< array.length-1;++i){

            for(int j=0;j< array.length-i-1; ++j){

                if (array[j+1]<array[j]) {
                    double swap = array[j];
                    array[j] = array[j+1];
                    array[j+1] = swap;

                }
            }
        }
    }

    public static double[] multiply(double[][] matrix, double[] vector) throws Exception {
        if (vector.length==matrix[0].length) {
            double[] result = new double[matrix.length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    result[i] += matrix[i][j] * vector[j];
                }
            }
            return result;
        } else throw new Exception("Количество столбцов в матрице не совпадает с количеством элментов в векторе-столбце");
    }
    public static double[][] multiply(double[][] matrixLeft, double[][] matrixRight) throws Exception {
        final int rightMatrixRows = matrixRight[0].length;
        final int leftMatrixCols = matrixLeft.length;
        double[][] result = new double[rightMatrixRows][leftMatrixCols];
        if (rightMatrixRows == leftMatrixCols) {
            for (int i = 0; i < rightMatrixRows; i++) {
                for (int j = 0; j < leftMatrixCols; j++) {
                    for (int k = 0; k < matrixRight.length; k++) {
                        result[i][j] += matrixLeft[i][k] * matrixRight[k][j];
                    }
                }
            }
            return result;
        } else throw new Exception("Количество столбцов в матрице не совпадает с количеством элментов в векторе-столбце");
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String line = scanner.nextLine();
        System.out.println(findMax(getArray(line)));
        System.out.println(findMin(getArray(line)));
    }
}
