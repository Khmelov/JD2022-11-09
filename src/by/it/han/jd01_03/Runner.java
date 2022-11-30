package by.it.han.jd01_03;

import java.util.Arrays;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        double[][] matrixLeft = {
                {1, 2, 3},
                {4, 5, 6}
        };
        double[][] matrixRight = {{1, 2},
                {3, 4},
                {5, 6}};
        double[] vector = {1, 2};

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        double[] array = InOut.getArray(input);
        InOut.printArray(array);
        InOut.printArray(array, "doubles", 2);

        System.out.println("Max: " + Helper.findMax(array));
        System.out.println("Min: " + Helper.findMin(array));
        Helper.sort(array);
        System.out.println(Arrays.toString(array));

        System.out.println(Arrays.toString(Helper.multiply(matrixRight, vector)));
        System.out.println(Arrays.deepToString(Helper.multiply(matrixRight, matrixLeft)));
    }
}
