package by.it.samatokhin.jd01_13;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {
        ArrayList<String> scannerValues = collectScannerValues();
        try {
            double sum = 0;
            for (String value : scannerValues) {
                double valueDouble = Double.parseDouble(value);
                sum = sum + valueDouble;
                double sqrtValue = Math.sqrt(sum);
                if (Double.isNaN(sqrtValue)) {
                    throw new ArithmeticException();
                } else {
                    System.out.println(sqrtValue);
                }
            }
        } catch (NumberFormatException | ArithmeticException | NullPointerException e) {
            String taskAClassName = TaskB.class.getName();
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
                            exceptionName, className, lineNumber);
                    break;
                }
            }
        }
    }

    private static ArrayList<String> collectScannerValues() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> scannerInLst = new ArrayList<>();
        while (true) {
            String value = scanner.next();
            if (value.equals("END")) {
                break;
            } else {
                scannerInLst.add(value);
            }
        }
        return scannerInLst;
    }
}
