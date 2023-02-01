package by.it.cherny.jd01_05;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Math.cbrt;
import static java.lang.Math.pow;

public class TaskC {

    public static final int MIN_ARRAY_LENGTH = 20;
    public static final int MAX_ARRAY_LENGTH = 40;

    public static void main(String[] args) {
        taskC1();
    }

    static void taskC1() {
        int randomArrayLength = ThreadLocalRandom.current().nextInt(MIN_ARRAY_LENGTH, MAX_ARRAY_LENGTH + 1);
        double delta = (9 - 5.33) / (randomArrayLength);

        System.out.println("Array consist of "+randomArrayLength+" elements");
        List<Double> arrayList = fillArray(delta);
        System.out.println(arrayList);

        List<Double> arrayB = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i)>3.5){
                arrayB.add(arrayList.get(i));
            }
        }
        System.out.println(arrayB);
        double geometric = calculateGeometricMean(arrayB);
        System.out.println(geometric);
    }

    private static double calculateGeometricMean(List<Double> arrayB) {
        double total = 1;
        for (int i = 0; i < arrayB.size(); i++) {
            total *= arrayB.get(i);
        }
        return pow(total, 1.0 / arrayB.size());
    }

    private static List<Double> fillArray(double delta) {
        List<Double> arrayList = new ArrayList<>();

        for (double i = 5.33; i <= 9.0; i += delta) {
            arrayList.add(cbrt(i * i + 4.5));
        }
        return arrayList;
    }
}
