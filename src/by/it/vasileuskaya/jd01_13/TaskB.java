package by.it.vasileuskaya.jd01_13;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double sum = 0;
        double result = 0;
        for (; ; ) {
            String value = scanner.next();
            if (value.equals("END")) {
                break;
            }
            try {
                double valueFromString = Double.parseDouble(value);
                System.out.println(value);
                sum += valueFromString;
                result = Math.sqrt(sum);
                System.out.println(result);
                if (sum < 0) {
                    throw new ArithmeticException();
                }
            } catch (NumberFormatException | ArithmeticException e) {
                Class<TaskB> taskBClass = TaskB.class;
                String taskBClassName = taskBClass.getName();
                StackTraceElement[] stackTrace = e.getStackTrace();
                for (StackTraceElement stackTraceElement : stackTrace) {
                    if (stackTraceElement.getClassName().equals(taskBClassName)) {
                        Class<? extends RuntimeException> bClass = e.getClass();
                        String nameException = bClass.getName();
                        int lineNumber = stackTraceElement.getLineNumber();
                        System.out.printf("name: %s%n class: %s%n line: %s%n", nameException, stackTraceElement.getClassName(), lineNumber);
                        break;
                    }
                }
            }
        }
    }
}