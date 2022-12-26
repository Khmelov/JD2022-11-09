package by.it.cherny.jd01_13;

import java.util.*;

public class TaskC {
    private static int count=0;
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        readData(sc);
    }

    private static void readData(Scanner sc) throws InterruptedException {
        List<Object> list = new LinkedList<>();
        while (true){
            try {
                String string = sc.next();
                Double number = Double.parseDouble(string);
                list.add(number);
            } catch (RuntimeException e){
                count++;
                Thread.sleep(100);
                printReverse(list);
            }
            if (count>4){
                throw new RuntimeException();
            }
        }
    }

    private static void printReverse(List<Object> list) {
        ListIterator<Object> iterator = list.listIterator(list.size());
        while (iterator.hasPrevious()){
            System.out.print(iterator.previous()+" ");
        }
        System.out.println();
    }
}
