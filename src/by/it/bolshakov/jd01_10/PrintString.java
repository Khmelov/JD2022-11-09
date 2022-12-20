package by.it.bolshakov.jd01_10;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) throws Exception {
        for (Method method : "".getClass().getDeclaredMethods()) {
            if (!((method.getModifiers() & Modifier.STATIC) == Modifier.STATIC))
                System.out.println(method.getName());
        }
    }
}
