package by.it.vasileuskaya.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5) {
                new HashMap<String, String>(null);
            } else {
                Integer.parseInt("привет");
            }
        } catch (NumberFormatException | NullPointerException e) {


            Class<TaskA> taskAClass = TaskA.class;
            String taskAClassName = taskAClass.getName();
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (stackTraceElement.getClassName().equals(taskAClassName)) {
                    Class<? extends RuntimeException> aClass = e.getClass();
                    String nameException = aClass.getName();
                    int lineNumber = stackTraceElement.getLineNumber();
                    System.out.printf("name: %s%n class: %s%n line: %s%n", nameException, stackTraceElement.getClassName(), lineNumber);
                    break;
                }
            }
        }
    }
}
