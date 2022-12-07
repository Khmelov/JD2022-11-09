package by.it.boycova.jd01_04;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        printMulTable();
        Scanner scanner = new Scanner(System.in);
        String line=scanner.nextLine();
        buildOneDimArray(line);

    }

    public static final String NAME = "V";

    static void printMulTable() {
        int [][] table= new int[8][8];
        int num_mult=2;
        int num_ind=2;
        for (int i = 0; i <table.length ; i++) {
            for (int j = 0; j < table.length; j++) {
                int res=num_mult*num_ind;
                if(res<10) {
                    System.out.print(num_mult + "*" + num_ind + "=" + res + "  ");
                }
                else {
                    System.out.print(num_mult + "*" + num_ind + "=" + res + " ");
                }
                num_ind++;

                if(num_ind==10){
                    System.out.println();
                    num_ind=2;
                }
            }
            num_mult++;
        }
    }
    static void buildOneDimArray(String line) {

        line = line.trim();
        String[] stringArray = line.split(" ");
        double[] array = new double[stringArray.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Double.parseDouble(stringArray[i]);
        }
        int enter = 0;
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s[% -4d ]=%-9.3f", NAME, i, array[i]);
            enter++;
            if (enter % 5 == 0) {
                System.out.println();
            }
        }
        System.out.println();

        double[] arrayNew= new double[array.length];
        for (int i = 0; i < array.length; i++) {
            arrayNew[i]=array[i];

        }

        boolean unsorted = true;
        double max;
        while (unsorted) {
            unsorted = false;
            for (int i = 0; i < arrayNew.length - 1; i++) {
                if (arrayNew[i] > arrayNew[i + 1]) {
                    max = arrayNew[i];
                    arrayNew[i] = arrayNew[i + 1];
                    arrayNew[i + 1] = max;
                    unsorted = true;
                }
            }
        }
        int counter=0;
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s[% -4d]=%-9.3f", NAME, i, array[i]);
            counter++;
            if (counter%4==0 && i!=0) {
                System.out.println();
            }
        }
        System.out.println();

        for (int i = 0; i < arrayNew.length; i++) {
            if (arrayNew[i] == array[0]) {
                System.out.println("Index of first element=" + i);
            }
        }
        for (int i = 0; i < arrayNew.length; i++)
            if (arrayNew[i] == array[array.length-1]) {
                System.out.println("Index of last element=" + i);
            }
        }
}
