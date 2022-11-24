package by.it.cherny.jd01_03;

import java.util.Locale;

public class Runner {

    public static final String NAME = "V";
    public static final int COLS_COUNT = 5;

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
//        Scanner sc = new Scanner(System.in);
//        String line = sc.nextLine();
//        double[] array=InOut.getArray(line);
//        InOut.printArray(array);
//        InOut.printArray(array, NAME, COLS_COUNT);
//        System.out.println(Helper.findMax(array));
//        System.out.println(Helper.findMin(array));
//        Helper.sort(array);
//        Helper.multiply(3.3, 3.2);
        double[][] d={{1,2,3},{4,5,6}};
        double[] t ={1.2, 2.3};
        Helper.multiply(d,t);
    }
}
