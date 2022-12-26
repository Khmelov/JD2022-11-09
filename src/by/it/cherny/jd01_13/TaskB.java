package by.it.cherny.jd01_13;

import java.util.Arrays;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double sum = 0;
        while (sc.hasNext()){
            String s = sc.next();
            if (s.equals("END")){
                break;
            }
            try {
                Double d = Double.parseDouble(s);
                sum+=d;
                System.out.println(Math.sqrt(sum));
                if (sum<0){
                    throw new ArithmeticException();
                }
            } catch (ArithmeticException | NumberFormatException e){
                String taskAClassName = TaskB.class.getName();
//                System.out.println(Arrays.toString(e.getStackTrace()));
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    String className = stackTraceElement.getClassName();
                    if (className.equals(taskAClassName)) {
                        Class<? extends RuntimeException> aClass = e.getClass();
                        String exceptionName = aClass.getName();
                        int lineNumber = stackTraceElement.getLineNumber();
                        System.out.printf("" +
                                        " name: %s%n" +
                                        "class: %s%n" +
                                        " line: %s%n",
                                exceptionName,className,lineNumber);
                        break;
                    }
                }
            }
        }
    }
}
