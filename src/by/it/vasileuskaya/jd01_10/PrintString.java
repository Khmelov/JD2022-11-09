package by.it.vasileuskaya.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {
        Class<String> aClass = String.class;
        Method[] methods = aClass.getDeclaredMethods();

        for (Method method : methods) {
            StringBuilder outMethods = new StringBuilder();
            int modifiers = method.getModifiers();
            if (!(Modifier.isStatic(modifiers))) {
                outMethods.append(method.getName());
                System.out.println(outMethods);
            }
        }
    }
}
