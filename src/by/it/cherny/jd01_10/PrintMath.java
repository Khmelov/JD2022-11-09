package by.it.cherny.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.StringJoiner;

public class PrintMath {

    public static final String PROTECTED_ = "protected ";
    public static final String PUBLIC_ = "public ";
    public static final String STATIC_ = "static ";
    public static final String SPACE = " ";

    public static void main(String[] args) {
        Class<?> structureSomeClass = Math.class;
//        Class<?> structureSomeClass = String.class;
        Method[] declaredMethods = structureSomeClass.getDeclaredMethods();

        for (Method method : declaredMethods) {
            StringBuilder builder = new StringBuilder();
            int modifiers = method.getModifiers();

            if (Modifier.isPublic(modifiers)) fillModifiers(modifiers, builder);
            else {continue;};

            builder.append(method.getReturnType().getSimpleName()).append(SPACE);
            builder.append(method.getName());

            StringJoiner stringJoiner = getParams(method);
            builder.append(stringJoiner);
            System.out.println(builder);
        }

        // ----------------------------
        Field[] declaredFields = structureSomeClass.getDeclaredFields();

        for (Field field : declaredFields) {
            StringBuilder builder = new StringBuilder();
            int modifiers = field.getModifiers();

            if (Modifier.isPublic(modifiers)) fillModifiers(modifiers, builder);
            else {continue;};
            builder.append(field.getType()).append(SPACE);
            builder.append(field.getName());

            System.out.println(builder);
        }
    }

    private static StringJoiner getParams(Method method) {
        Class<?>[] parameterTypes = method.getParameterTypes();
        StringJoiner stringJoiner = new StringJoiner(",", "(", ")");

        for (Class<?> parameterType : parameterTypes) {
            stringJoiner.add(parameterType.getSimpleName());
        }
        return stringJoiner;
    }

    private static void fillModifiers(int modifiers, StringBuilder builder) {
        if (Modifier.isPublic(modifiers)){
            builder.append(PUBLIC_);
        }
        if (Modifier.isProtected(modifiers)){
            builder.append(PROTECTED_);
        }
        if (Modifier.isStatic(modifiers)){
            builder.append(STATIC_);
        }
    }

    public static float abs(float a){

        return a;
    }
}
