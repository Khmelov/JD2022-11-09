package by.it.cherny.jd01_04;

import java.util.Arrays;

public class TaskC {
    public static void main(String[] args) {
        buildOneDimArray(" 1 23 23.2 4 34.3 23.12");
    }
    private static void buildOneDimArray(String line){
        line = line.trim();
        String[] stringArray = line.split(" ");
        double[] array = new double[stringArray.length];
        for (int i = 0; i < array.length; i++) {
            array[i]=Double.parseDouble(stringArray[i]);
        }
        for (int i = 0; i < array.length; i++) {
            if (i%5==0){
                System.out.println();
            }
            System.out.printf("V[%d]=%.2f ", i, array[i]);
        }
        System.out.println();
        double[] oldArray = Arrays.copyOf(array, array.length);
        mergeSort(array);
        int first = binarySearch(array, oldArray[0]);
        int last = binarySearch(array, oldArray[oldArray.length-1]);

        for (int i = 0; i < array.length; i++) {
            if (i%4==0){
                System.out.println();
            }
            System.out.printf("V[%d]=%.2f ", i, array[i]);
        }
        System.out.println();
        System.out.printf("Index of first element=%d\n",first);
        System.out.printf("Index of last element=%d\n",last);
    }
    private static void mergeSort(double[] array){
        if (array.length<2) return;
        int midLength = array.length/2;
        double[] left = new double[midLength];
        double[] right = new double[array.length-midLength];

        for (int i = 0; i < midLength; i++) {
            left[i]=array[i];
        }
        for (int i = midLength; i < array.length; i++) {
            right[i - midLength] = array[i];
        }
        mergeSort(left);
        mergeSort(right);

        double[] newArray = merge(array, left, right);
        System.out.println(Arrays.toString(newArray));
    }
    public static double[] merge(
            double[] array, double[] left, double[] right) {

        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            }
            else {
                array[k++] = right[j++];
            }
        }
        while (i< left.length) {
            array[k++] = left[i++];
        }
        while (j < right.length) {
            array[k++] = right[j++];
        }
        return array;
    }
    private static int binarySearch(double[] array, double value){
        int firstIndex = 0;
        int lastIndex = array.length - 1;
        while(firstIndex <= lastIndex) {
            int middleIndex = (firstIndex + lastIndex) / 2;
            if (array[middleIndex] == value) {
                return middleIndex;
            }
            else if (array[middleIndex] < value){
                firstIndex = middleIndex + 1;
            }
            else if (array[middleIndex] > value){
                lastIndex = middleIndex - 1;
            }
        }
        return -1;
    }
}
