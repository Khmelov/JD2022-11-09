package by.it.samatokhin.jd01_04;

import java.util.Arrays;

class Helper {
    public static void main(String[] args) {

    }
    public static double findMin(double[ ] array){
        double min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }
    public static double findMax(double[ ] array){
        double max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
    static void sort(double[] array) {
        Arrays.sort(array);
    }
}