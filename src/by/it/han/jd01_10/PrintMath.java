package by.it.han.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.StringJoiner;

public class PrintMath {

    private static final String PUBLIC = "public ";
    private static final String STATIC = "static ";
    private static final String FINAL = "final ";
    private static final String SPACE = " ";

    public static void main(String[] args) {
        Class<Math> mathClass = Math.class;
        StringBuilder sb = new StringBuilder();
        addPublicFields(mathClass, sb);
        addPublicMethods(mathClass, sb);
        System.out.println(sb);
    }

    private static void addPublicMethods(Class<Math> mathClass, StringBuilder sb) {
        for (Method method : mathClass.getDeclaredMethods()) {
            int modifiers = method.getModifiers();
            if (Modifier.isPublic(modifiers)) {
                sb.append(PUBLIC);
            } else {
                continue;
            }
            if (Modifier.isStatic(modifiers)) {
                sb.append(STATIC);
            }
            sb.append(method.getReturnType())
                    .append(SPACE)
                    .append(method.getName());
            Class<?>[] parameterTypes = method.getParameterTypes();
            StringJoiner sj = getStringJoiner(parameterTypes);
            sb.append(sj)
                    .append("\n");
        }
    }

    private static void addPublicFields(Class<?> mathClass, StringBuilder sb) {
        for (Field field : mathClass.getDeclaredFields()) {
            int modifiers = field.getModifiers();
            if (Modifier.isPublic(modifiers)) {
                sb.append(PUBLIC);
            } else {
                continue;
            }
            if (Modifier.isStatic(modifiers)) {
                sb.append(STATIC);
            }
            if (Modifier.isFinal(modifiers)) {
                sb.append(FINAL);
            }
            sb.append(field.getType())
                    .append(SPACE)
                    .append(field.getName())
                    .append("\n");
        }
    }

    private static StringJoiner getStringJoiner(Class<?>[] parameterTypes) {
        StringJoiner sj = new StringJoiner(",", "(", ")");
        for (Class<?> parameterType : parameterTypes) {
            sj.add(parameterType.getSimpleName());
        }
        return sj;
    }

}
