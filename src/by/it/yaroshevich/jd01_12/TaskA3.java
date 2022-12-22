package by.it.yaroshevich.jd01_12;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int positionZero=0;
        for(;;){
            String value = scanner.next();
            if (value.equals("end")){
                break;
            }
            Integer integer = Integer.valueOf(value);
            if(integer>0){
                list.add(positionZero++, integer);
            } else if (integer < 0){
                list.add(integer);
            } else {
                list.add(positionZero, integer);
            }
            System.out.println(list);
        }
    }

}
