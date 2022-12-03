package by.it.cherny.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int people = sc.nextInt();
        String[] array = new String[people];
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.next();
        }
        int[][] salaryByQuarter = new int[people][4];
        for (int i = 0; i < array.length; i++) {
            System.out.printf("Введите зарплату для %s\n",array[i]);
            for (int j = 0; j < salaryByQuarter[0].length; j++) {
                salaryByQuarter[i][j]=sc.nextInt();
            }
        }
        System.out.printf("%-9s%-10s%-10s%-10s%-10s%-7s\n",
                "Фамилия","Квартал1",
                "Квартал2","Квартал3",
                "Квартал4","Итого");
        int total = 0;
        for (int i = 0; i < salaryByQuarter.length; i++) {
            System.out.printf("%-9s:",array[i]);
            for (int j = 0; j < salaryByQuarter[0].length+1; j++) {
                if (j< salaryByQuarter[0].length){
                    System.out.printf("%-9d ",salaryByQuarter[i][j]);
                } else {
                    int sum = 0;
                    for (int k = 0; k < salaryByQuarter[i].length; k++) {
                        sum+=salaryByQuarter[i][k];
                    }
                    total+=sum;
                    System.out.println(sum);
                }
            }
        }
        double avg = total / (people * 4.0);
        System.out.printf("%-10s%d\n%-10s%.5f",
                "Итого",total,
                "Средняя",avg);
    }
}
