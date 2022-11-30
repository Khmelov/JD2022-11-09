package by.it.vasileuskaya.jd01_04;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        printMulTable();
        Scanner scan = new Scanner(System.in);
        System.out.println("Please, enter some numbers to create an array:");
        String line = scan.nextLine();
        buildOneDimArray(line);
    }

    static void printMulTable() {
        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                System.out.printf("%d*%d=%-3d", i, j, i * j);
            }
            System.out.println();
        }
    }

    static void buildOneDimArray(String line) {
        double[] array = getArray(line);
        double firstElement = array[0];
        double lastElement = array[array.length - 1];
        printArray(array, "V", 5);
        sort(array);
        printArray(array, "V", 4);
        int indexFirstElement = 0;
        int indexLastElement = 4;
        for (int i = 0; i < array.length; i++) {
            if (firstElement == array[i]) {
                indexFirstElement = i;
            }
            if (lastElement == array[i]) {
                indexLastElement = i;
            }
        }
        System.out.printf("Index of first element=%d%n" + "Index of last element=%d%n", indexFirstElement, indexLastElement);
    }

    static double[] getArray(String line) {
        line = line.trim();
        String[] arrayFromString = line.split(" ");
        double[] arrayFromDouble = new double[arrayFromString.length];
        for (int i = 0; i < arrayFromDouble.length; i++) {
            arrayFromDouble[i] = Double.parseDouble(arrayFromString[i]);
        }
        return arrayFromDouble;
    }

    static void printArray(double[] array, String nameArray, int countColumns) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s[%03d]=%-7.3f  ", nameArray, i, array[i]);
            if (i == array.length - 1 || (i + 1) % countColumns == 0) {
                System.out.println();
            }
        }
    }

    private static void sort(double[] array) {
        boolean checkSort;
        int countSort = array.length;
        do {
            checkSort = false;
            for (int i = 1; i < countSort; i++) {
                if (array[i] < array[i - 1]) {
                    double temporaryValue = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temporaryValue;
                    checkSort = true;
                }
            }
            countSort--;
        } while (checkSort);
    }
}

