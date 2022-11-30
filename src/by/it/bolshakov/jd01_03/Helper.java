package by.it.bolshakov.jd01_03;

import java.util.Arrays;
import java.util.Scanner;

import static by.it.bolshakov.jd01_03.InOut.getArray;

public class Helper {

    static double findMin(double[ ] array) {
        sort(array);
        return array[0];
    }

    static double findMax(double[ ] array) {
        sort(array);
        return array[array.length-1];
    }

    static void sort(double[ ] array) {
        for (int i=0;i< array.length-1;++i){

            for(int j=0;j< array.length-i-1; ++j){

                if (array[j+1]<array[j]) {
                    double swap = array[j];
                    array[j] = array[j+1];
                    array[j+1] = swap;

                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String line = scanner.nextLine();
        System.out.println(findMax(getArray(line)));
        System.out.println(findMin(getArray(line)));
    }
}
