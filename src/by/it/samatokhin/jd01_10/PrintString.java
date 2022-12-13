package by.it.samatokhin.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashSet;

public class PrintString {
    public static void main(String[] args) {

        Method[] methods = String.class.getDeclaredMethods();
        HashSet<String> methodNames = new HashSet<String>();

        for (Method method : methods) {
            if (!Modifier.isStatic(method.getModifiers())) {
                methodNames.add(method.getName());
            }
        }
        for (String name : methodNames) {
            System.out.println(name);
        }
    }

}
