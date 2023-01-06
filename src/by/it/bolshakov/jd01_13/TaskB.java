package by.it.bolshakov.jd01_13;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double sum = 0;
        for (; ; ) {
            String line = scanner.nextLine();
            if (line.equals("END")) {
                break;
            }
            try {
                double number = Double.parseDouble(line);
                sum+=number;
                System.out.println(number);
                if (sum < 0) {
                    throw new ArithmeticException();
                }
                System.out.println(Math.sqrt(sum));
            } catch (NumberFormatException | ArithmeticException e) {
                String taskBClassName = TaskB.class.getName();
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    String className = stackTraceElement.getClassName();
                    if (className.equals(taskBClassName)) {
                        Class<? extends RuntimeException> bClass = e.getClass();
                        String exceptionName = bClass.getName();
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
