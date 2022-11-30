package by.it.vasileuskaya.jd01_03;

import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        double[] array = InOut.getArray(line);
        double[][] matrixForExample = {{23, 3, 4}, {3, 42, 2}, {5, 61, 4}};
        double[] vektorForExample = {23, 4.5, 2};
        double[][] matrixLeft = {{2, 4, 5}, {4, 7, 8}};
        double[][] matrixRight = {{2, 5, 6}, {5, 6, 8}, {5, 4, 3}};


        InOut.printArray(array);
        InOut.printArray(array, "V", 3);
        Helper.findMin(array);
        Helper.findMax(array);
        Helper.sort(array);
        Helper.multiply(matrixForExample, vektorForExample);
        Helper.multiply(matrixLeft, matrixRight);
    }
}
