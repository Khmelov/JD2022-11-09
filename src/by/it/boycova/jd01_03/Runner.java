package by.it.boycova.jd01_03;

import java.util.Scanner;

public class Runner {


    public static final String NAME = "V";
    public static final int COLUMN_COUNT = 3;


    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        String line=scanner.nextLine();
        double [] array= InOut.getArray(line);
        InOut.printArray(array);
        InOut.printArray(array, NAME, COLUMN_COUNT);


        Helper.findMin(array);
        Helper.findMax(array);
        Helper.sort(array);

    }
}



