package by.it.khmelov.jd01_03;

import java.util.Locale;
import java.util.Scanner;

public class Runner {

    public static final String NAME = "V";
    public static final int COLUMN_COUNT = 5;

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        double[] array=InOut.getArray(line);
        InOut.printArray(array);
        InOut.printArray(array, NAME, COLUMN_COUNT);
    }
}
