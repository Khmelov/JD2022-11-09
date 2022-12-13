package by.it.yaroshevich.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.StringJoiner;

public class PrintMath {

    public static final String PUBLIC_ = "public ";
    public static final String PRIVATE = "private";
    public static final String PROTECTED_ = "protected ";
    public static final String STATIC_ = "static ";
    public static final String SPACE = " ";
    public static final String DELIMITER = ",";
    public static final String PREFIX = "(";
    public static final String SUFFIX = ")";

    public static void main(String[] args) {
        Class<?> aClss = Math.class;
        Method[] methods = aClss.getDeclaredMethods();
        Field[] fields = aClss.getDeclaredFields();

        for (Method method:methods) {
            StringBuilder out = new StringBuilder();
            int modifiers = method.getModifiers();
            if (Modifier.isPublic(modifiers)) {
                out.append(PUBLIC_);
            } else {
                continue;
            }
            if (Modifier.isPrivate(modifiers)) {
                out.append(PRIVATE);
            }
            if (Modifier.isProtected(modifiers)) {
                out.append(PROTECTED_);
            }
            if (Modifier.isStatic(modifiers)) {
                out.append(STATIC_);
            }
            out.append(method.getReturnType().getSimpleName()).append(SPACE);
            out.append(method.getName());
            Class<?>[] parametrTypes = method.getParameterTypes();
            StringJoiner stringJoiner = new StringJoiner(DELIMITER, PREFIX, SUFFIX);
            for (Class<?> parametrType : parametrTypes) {
                stringJoiner.add(parametrType.getSimpleName());
            }
            out.append(stringJoiner);
            System.out.println(out);
        }
        for(Field field:fields) {
            StringBuilder out = new StringBuilder();
            int modifiers = field.getModifiers();
            if (Modifier.isPublic(modifiers)) {
                out.append(field.getGenericType());
                out.append(" ");
                out.append(field.getName());
                System.out.println(out);
            }
        }

    }

}