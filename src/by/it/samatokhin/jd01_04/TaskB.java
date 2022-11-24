package by.it.samatokhin.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countGuys = scanner.nextInt();
        String[] families = new String[countGuys];
        for (int i = 0; i < families.length; i++) {
            String secondName = scanner.next();
            families[i] = secondName;
            System.out.println(secondName);
        }
    }
}
