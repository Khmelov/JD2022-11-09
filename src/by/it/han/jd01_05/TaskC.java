package by.it.han.jd01_05;

import java.util.Arrays;

import static java.lang.Math.pow;
import static java.lang.Math.random;

public class TaskC {

    private static final String SEPARATOR_FIRST = "═════════════╦═════════════╦═════════════╦═════════════╦═════════════";
    private static final String SEPARATOR_MIDDLE = "═════════════╬═════════════╬═════════════╬═════════════╬═════════════";
    private static final String SEPARATOR_LAST = "═════════════╩═════════════╩═════════════╩═════════════╩═════════════";

    public static void main(String[] args) {
        step1();
        step2();
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
        System.out.printf("Среднее значение: %.5f%n", getGeometryAverage(secondArray));
    }

    public static double[] getArray(String arrayName) {
        double n = 0;
        double maxX = 9;
        double minX = 5.33;
        int count = 0;
        while (count < 20 || count > 40) {
            n = random() * 0.3;
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

    public static void step2() {
        int[] a = getArrayA();
        int[] b = getArrayB(a);
        printArrA(a);
        printArrB(b);
    }

    public static int[] getArrayA() {
        int[] a = new int[31];
        Arrays.setAll(a, i -> (int) (random() * 347) + 103);
        return a;
    }

    public static int[] getArrayB(int[] array) {
        int[] c = Arrays.stream(array).sorted().toArray();
        int count = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i] * 0.1 > i) {
                count++;
            }
        }
        int[] b = new int[count];
        for (int i = 0, i1 = 0; i < c.length; i++) {
            if (c[i] * 0.1 > i) {
                b[i1] = c[i];
                i1++;
            }
        }
        return b;
    }

    public static void printArrA(int[] array) {
        int countElementsRow = 0;
        for (int i = 0; i < array.length; i++) {
            countElementsRow++;
            if (i == 0) {
                System.out.printf("%s%s%s%n", "╔", SEPARATOR_FIRST, "╗");
            }
            System.out.printf("%s", "║");
            System.out.printf(" %s[%2d] = %d ", "A", i, array[i]);
            if (countElementsRow == 5) {
                System.out.printf("%s", "║");
                System.out.printf("%n%s%s%s%n", "╠", SEPARATOR_MIDDLE, "╣");
                countElementsRow = 0;
            }
            if (i == array.length - 1) {
                System.out.printf("%s", "║");
            }
        }
        System.out.printf("%n%s%s%s%n", "╚", SEPARATOR_LAST, "╝");
    }

    public static void printArrB(int[] array) {
        int col = 7;
        int[][] newArr = get2DArray(array, col);
        for (int i = 0; i < newArr.length; i++) {
            int count = i;
            if (i == 0) {
                System.out.printf("%s%s%s%n", "╔", SEPARATOR_FIRST, "╗");
            }
            for (int j = 0; j < newArr[i].length; j++) {
                if (newArr[i][j] != 0) {
                    System.out.printf("%s %s[%2d] = %d ", "║", "B", count, newArr[i][j]);
                }
                count += col;
            }
            if (i == newArr.length - 1) {
                System.out.printf("%n%s%s%s%n", "╚", SEPARATOR_LAST, "╝");
            } else {
                System.out.printf("%n%s%s%s%n", "╠", SEPARATOR_MIDDLE, "╣");
            }
        }
    }

    public static int[][] get2DArray(int[] array, int col) {
        int startPos = 0;
        int row = array.length / col;
        int countNumberLastArray = array.length - (col * row);
        int[][] arr2D = new int[row + 1][col];
        for (int i = 0; i < row + 1; i++) {
            if (i == row) {
                System.arraycopy(array, startPos, arr2D[i], 0, countNumberLastArray);
            } else {
                System.arraycopy(array, startPos, arr2D[i], 0, col);
                startPos += arr2D[i].length;
            }
        }
        int[][] newArr = new int[col][row + 1];
        for (int i = 0; i < arr2D.length; i++) {
            for (int j = 0; j < arr2D[i].length; j++) {
                newArr[j][i] = arr2D[i][j];
            }
        }
        return newArr;
    }
}
