package by.it.samatokhin.jd01_03;

import java.util.Locale;
import java.util.Scanner;

public class Runner {

    public static final String NAME = "V";
    public static final int COLUMN_COUNT = 5;

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        double[] array= InOut.getArray(line);
        InOut.printArray(array);
        InOut.printArray(array, NAME, COLUMN_COUNT);
        double min = Helper.findMin(array);
        double max = Helper.findMax(array);
        System.out.println(" Минимум = " + min);
        System.out.println(" Максимум = " + max);
    }
    public static void printArray(int [] array){
        for (int i = 0; i<array.length; i++) {
            System.out.print(array[i]+ " ");
        }
        System.out.println("");

    }
}