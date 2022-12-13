package by.it.yaroshevich.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {
        Class<?> aClss = String.class;
        Method[] methods = aClss.getDeclaredMethods();

        for (Method method:methods) {
            StringBuilder out = new StringBuilder();
            int modifiers = method.getModifiers();
            if (Modifier.isStatic(modifiers)) {
                continue;
            } else {
                out.append(method.getName());
                System.out.println(out);
            }
        }
    }
}
