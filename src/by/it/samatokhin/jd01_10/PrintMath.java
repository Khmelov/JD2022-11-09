package by.it.samatokhin.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.StringJoiner;

public class PrintMath {

    public static final String PUBLIC_ = "public ";
    public static final String PRIVATE_ = "private ";
    public static final String PROTECTED_ = "protected ";
    public static final String STATIC_ = "static ";
    public static final String SPACE = " ";
    public static final String DELIMITER = ",";
    public static final String PREFIX = "(";
    public static final String SUFFIX = ")";

    public static void main(String[] args) {

        printMethodsNames();
        printFieldNames();
    }

    private static void printMethodsNames() {

        Method[] methods = Math.class.getDeclaredMethods();
        for (Method method : methods) {
            StringBuilder out = new StringBuilder();
            if (!fillModifiers(method.getModifiers(), out)) {
                continue;
            }
            out.append(method.getReturnType().getSimpleName()).append(SPACE);
            out.append(method.getName());
            StringJoiner stringJoiner = getParamString(method);
            out.append(stringJoiner);
            System.out.println(out);
        }
    }

    private static void printFieldNames() {
        Field[] fields = Math.class.getDeclaredFields();
        for (Field field : fields) {
            if (Modifier.isPublic(field.getModifiers())) {
                StringBuilder out = new StringBuilder();
                if (!fillModifiers(field.getModifiers(), out)) {
                    continue;
                }
                out.append(field.getType()).append(SPACE);
                out.append(field.getName());
                System.out.println(out);
            }
        }
    }

    private static StringJoiner getParamString(Method method) {
        Class<?>[] parameterTypes = method.getParameterTypes();
        StringJoiner stringJoiner = new StringJoiner(DELIMITER, PREFIX, SUFFIX);
        for (Class<?> parameterType : parameterTypes) {
            stringJoiner.add(parameterType.getSimpleName());
        }
        return stringJoiner;
    }

    private static boolean fillModifiers(int modifiers, StringBuilder out) {

        if (Modifier.isPublic(modifiers)) {
            out.append(PUBLIC_);
        } else {
            return false;
        }
        if (Modifier.isPrivate(modifiers)) {
            out.append(PRIVATE_);
        }
        if (Modifier.isProtected(modifiers)) {
            out.append(PROTECTED_);
        }
        if (Modifier.isStatic(modifiers)) {
            out.append(STATIC_);
        }
        return true;
    }
}
