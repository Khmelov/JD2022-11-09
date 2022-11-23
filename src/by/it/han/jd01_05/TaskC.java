package by.it.han.jd01_05;

import java.util.Arrays;

import static java.lang.Math.pow;

public class TaskC {

    public static void main(String[] args) {
        step1();
    }

    public static void step1() {
        String firstArrayName = "A";
        String secondArrayName = "B";
        double min = 3.5;
        double[] firstArray = getArray("A");
        System.out.println();
        printArray(firstArray, firstArrayName);
        System.out.println();
        double[] secondArray = Arrays.stream(firstArray).filter(value -> value > min).toArray();
        System.out.printf("Массив %s[] из элементов массива %s > %.1f%n", secondArrayName, firstArrayName, min);
        printArray(secondArray, secondArrayName);
        System.out.println("Среднее значение: " + getGeometryAverage(secondArray));
    }


    public static double[] getArray(String arrayName) {
        double n = Math.random() * 0.3;
        double maxX = 9;
        double minX = 5.33;
        int count = (int) ((maxX - minX) / n);
        while (count > 19 && count < 41) {
            count = (int) ((maxX - minX) / n);
        }
        double[] array = new double[count];
        System.out.printf("Массив %s[]", arrayName);
        double x = minX;
        for (int i = 0; i < count; i++) {
            array[i] = pow(pow(x, 2) + 4.5, 1.0 / 3);
            x += n;
        }
        return array;
    }

    private static double getGeometryAverage(double[] array) {
        double multi = 1;
        for (int i = 0; i < array.length; i++) {
            multi *= array[i];
        }
        return multi / array.length;
    }

    public static void printArray(double[] array, String arrayName) {
        int countElementsRow = 0;
        for (int i = 0; i < array.length; i++) {
            countElementsRow++;
            if (i < 10) {
                System.out.printf("%s[ %d ] = %-10.5f", arrayName, i, array[i]);
            } else {
                System.out.printf("%s[%3d] = %-10.5f", arrayName, i, array[i]);
            }
            if (countElementsRow == 5) {
                System.out.println();
                countElementsRow = 0;
            }
        }
        System.out.println();
    }
}
