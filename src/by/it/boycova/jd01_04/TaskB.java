
package by.it.boycova.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int n =scanner.nextInt();
        String[]lastNames=new String[n];
        for (int x = 0; x < lastNames.length; x++) {
            lastNames[x]= scanner.next();
        }


        int[][]salaryTable=new int[n][4];
        String[]salary=new String[4];
        for (int i = 0; i < salary.length; i++) {
            salary[i]=scanner.next();
        }
    }
}



