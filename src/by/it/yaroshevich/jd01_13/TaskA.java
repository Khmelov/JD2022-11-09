package by.it.yaroshevich.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {
        try {
            if (Math.random()>0.5){
                new HashMap<String ,String >(null);
            } else {
                Integer.parseInt("привет");
            }
        } catch (NumberFormatException | NullPointerException e){
           String taskAClassName = TaskA.class.getName();
           for (StackTraceElement stackTraceElement :e.getStackTrace()) {
                String className = stackTraceElement.getClassName();
                if (stackTraceElement.getClassName().equals(taskAClassName)){
                 Class<? extends RuntimeException> aClass = e.getClass(); 
                 String exceptionName = aClass.getName();                 System.out.println(stackTraceElement);
                    int lineNumber = stackTraceElement.getLineNumber();
                    System.out.printf(""+
                            " name: %s%n" +
                            "class: %s%n" +
                            " line: %s%n",
                            exceptionName, className, lineNumber);
                    break;
                }
            }
        }
    }
}
