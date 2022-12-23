package by.it.han.jd01_13;

import java.util.HashMap;

public class TaskA {

    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");
        } catch (NullPointerException | NumberFormatException e) {
            printException(e, TaskA.class);
        }
    }

    public static void printException(RuntimeException e, Class<?> c) {
        String className = c.getName();
        StackTraceElement[] stackTrace = e.getStackTrace();
        for (StackTraceElement stackTraceElement : stackTrace) {
            if (stackTraceElement.getClassName().equals(className)) {
                System.out.println("name: " + e.getClass().getName());
                System.out.println("class: " + className);
                System.out.println("line: " + stackTraceElement.getLineNumber());
            }
        }
    }
}
