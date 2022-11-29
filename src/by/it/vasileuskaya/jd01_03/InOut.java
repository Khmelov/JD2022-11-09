package by.it.vasileuskaya.jd01_03;

public class InOut {
    static double[] getArray(String line) {
        line = line.trim();
        String[] arrayFromString = line.split(" ");
        double[] arrayFromDouble = new double[arrayFromString.length];
        for (int i = 0; i < arrayFromDouble.length; i++) {
            arrayFromDouble[i] = Double.parseDouble(arrayFromString[i]);
        }
        return arrayFromDouble;
    }

    static void printArray(double[] array) {
        for (double element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void printArray(double[] array, String nameArray, int countColumns) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s[%03d]=%-7.3f  ", nameArray, i, array[i]);
            if (i == array.length - 1 || (i + 1) % countColumns == 0) {
                System.out.println();
            }
        }
    }
}
