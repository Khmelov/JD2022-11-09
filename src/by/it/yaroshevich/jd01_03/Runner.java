package by.it.yaroshevich.jd01_03;

import java.util.Scanner;

public class Runner {

    public static final String NAME = "V";
    public static final int COLS_COUNT = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        double[] array=InOut.getArray(line);
        double[][] matrixForExample = {{23, 3, 4}, {3, 42, 2}, {5, 61, 4}};
        double[] vectorForExample = {23, 4.5, 2};
        double[][] matrixLeft = {{2, 4, 5}, {4, 7, 8}};
        double[][] matrixRight = {{2, 5, 6}, {5, 6, 8}, {5, 4, 3}};
        InOut.printArray(array);
        InOut.printArray(array, NAME, COLS_COUNT);
        Helper.findMin(array);
        Helper.findMax(array);
        Helper.sort(array);
        Helper.multiply(matrixForExample, vectorForExample);
        Helper.multiply(matrixLeft, matrixRight);
    }
}
