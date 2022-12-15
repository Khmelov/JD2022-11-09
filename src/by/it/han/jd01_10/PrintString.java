package by.it.han.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {

    public static void main(String[] args) {
        Class<?> stringClass = String.class;
        printNonStaticMethods(stringClass);
    }

    private static void printNonStaticMethods(Class<?> stringClass) {
        for (Method method : stringClass.getDeclaredMethods()) {
            int modifiers = method.getModifiers();
            if (!Modifier.isStatic(modifiers)) {
                System.out.println(method.getName());
            }
        }
    }
}
