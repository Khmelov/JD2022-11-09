package by.it.yaroshevich.jd01_03;

import java.util.Scanner;

public class Runner {

    public static final String NAME = "V";
    public static final int COLS_COUNT = 5;
    public static final int COLUMN_COUNT1 = COLS_COUNT;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        double[] array=InOut.getArray(line);
        InOut.printArray(array);
        InOut.printArray(array, NAME, COLUMN_COUNT1);

        double min = Helper.findMin(array);
        double max = Helper.findMax(array);
        Helper.sort(array);
        System.out.println(min);
        System.out.println(max);

        //double[][] matrix = {{1,2}, {3,4}};
        //double[ ] vector = {1,2};
        //Helper.multiply(matrix, vector);

        //double[][] matrixLeft = {{1,2}, {3,4}};
        //double[][] matrixRight = {{1,2}, {3,4}};
        //Helper.multiply(matrixLeft, matrixRight);
    }
}
