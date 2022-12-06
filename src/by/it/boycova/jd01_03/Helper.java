package by.it.boycova.jd01_03;

public class Helper {

    public static double findMin(double[] array) {
        double min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    public static double findMax(double[] array) {
        double max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public static void sort(double[] array) {
        boolean unsorted = true;
        double max;
        while (unsorted) {
            unsorted = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    max = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = max;
                    unsorted = true;
                }
            }
        }
    }
}



