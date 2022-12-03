package by.it.cherny.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskA {
    private static final String SPACE = " ";

    public static void main(String[] args) {
        printMulTable();
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        buildOneDimArray(line);
    }
    private static void printMulTable(){
        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                System.out.printf("%d*%d=%-3d",i,j,i*j);
            }
            System.out.println();
        }
    }

    private static void buildOneDimArray(String line){
        line = line.trim();
        String[] stringArray = line.split(SPACE);
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
            boolean isSwapped;
            int swappedArrLength = array.length-1;
            double[] swappedArray = Arrays.copyOf(array, array.length);
            do {
                isSwapped = false;
                for (int i = 0; i < swappedArrLength; i++) {
                    if (swappedArray[i] > swappedArray[i + 1]) {
                        double buffer = swappedArray[i];
                        swappedArray[i] = swappedArray[i + 1];
                        swappedArray[i + 1] = buffer;
                        isSwapped = true;
                    }
                }
                swappedArrLength--;
            } while (isSwapped);
//            System.out.println(Arrays.toString(swappedArray));
        for (int i = 0; i < swappedArray.length; i++) {
            if (i%4==0){
                System.out.println();
            }
            System.out.printf("V[%d]=%.2f ", i, swappedArray[i]);
        }
        System.out.println();
        for (int i = 0; i < swappedArray.length; i++) {
            if (array[0]==swappedArray[i]){
                System.out.printf("Index of first element=%d\n",i);
            }
            if (array[array.length-1]==swappedArray[i]){
                System.out.printf("Index of last element=%d\n",i);
            }
        }
    }
}
