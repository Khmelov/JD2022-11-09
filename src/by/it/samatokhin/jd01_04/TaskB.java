package by.it.samatokhin.jd01_04;

import java.text.DecimalFormat;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countGuys = scanner.nextInt();
        String[] surname = new String[countGuys];
        for (int i = 0; i < surname.length; i++) {
            String secondName = scanner.next();
            surname[i] = secondName;
        }
        String[][] salary = new String[countGuys + 6][6];
        salary[0][0] = "--------";
        salary[0][1] = "--------";
        salary[0][2] = "--------";
        salary[0][3] = "--------";
        salary[0][4] = "--------";
        salary[0][5] = "--------";
        salary[1][0] = "Фамилия:";
        salary[1][1] = "Квартал1";
        salary[1][2] = "Квартал2";
        salary[1][3] = "Квартал3";
        salary[1][4] = "Квартал4";
        salary[1][5] = "Итого";
        salary[2][0] = "--------";
        salary[2][1] = "--------";
        salary[2][2] = "--------";
        salary[2][3] = "--------";
        salary[2][4] = "--------";
        salary[2][5] = "--------";

        int allSum = 0;

        for (int i = 0; i < surname.length; i++) {
            int line = 3 + i;
            String secondName = surname[i];
            salary[line][0] = secondName;
            System.out.println("Введите зарплату для " + secondName);
            int quarter1 = scanner.nextInt();
            int quarter2 = scanner.nextInt();
            int quarter3 = scanner.nextInt();
            int quarter4 = scanner.nextInt();
            int sumQuarters = quarter1 + quarter2 + quarter3 + quarter4;
            salary[line][1] = "\t\t" + Integer.toString(quarter1);
            salary[line][2] = "\t\t" + Integer.toString(quarter2);
            salary[line][3] = "\t\t" + Integer.toString(quarter3);
            salary[line][4] = "\t\t" + Integer.toString(quarter4);
            salary[line][5] = "\t\t" + Integer.toString(sumQuarters);
            allSum += sumQuarters;
        }
        salary[countGuys + 3][0] = "--------";
        salary[countGuys + 3][1] = "--------";
        salary[countGuys + 3][2] = "--------";
        salary[countGuys + 3][3] = "--------";
        salary[countGuys + 3][4] = "--------";
        salary[countGuys + 3][5] = "--------";
        salary[countGuys + 4][0] = "Итого";
        salary[countGuys + 4][1] = "\t\t" + Integer.toString(allSum);
        salary[countGuys + 4][2] = "\t";
        salary[countGuys + 4][3] = "\t";
        salary[countGuys + 4][4] = "\t";
        salary[countGuys + 4][5] = "\t";
        salary[countGuys + 5][0] = "Средняя";
        salary[countGuys + 5][1] = "\t\t" + (new DecimalFormat("0.0000")).format((Double.valueOf(allSum) / Double.valueOf(countGuys)) / 4);
        salary[countGuys + 5][2] = "\t";
        salary[countGuys + 5][3] = "\t";
        salary[countGuys + 5][4] = "\t";
        salary[countGuys + 5][5] = "\t";

        for (int i = 0; i < salary.length; i++) {
            for (int j = 0; j < salary[i].length; j++) {
                System.out.print(salary[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
