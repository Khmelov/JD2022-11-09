package by.it.cherny.jd01_12;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class TaskC3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String value = sc.next();
        String[] split = value.split("[\\[\\]}{()]");
        System.out.println(Arrays.toString(split));
        System.out.println(value);
    }
}
