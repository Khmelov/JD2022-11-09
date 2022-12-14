package by.it.vasileuskaya.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.StringJoiner;

public class PrintMath {

    public static final String PUBLIC_ = "public ";
    public static final String PRIVATE_ = "private ";
    public static final String PROTECTED_ = "protected ";
    public static final String STATIC_ = "static ";
    public static final String DELIMITER = ",";
    public static final String PREFIX = "(";
    public static final String SUFFIX = ")";
    public static final String SPACE = " ";

    public static void main(String[] args) {

        Class<Math> aClass = Math.class;
        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields) {
            StringBuilder outForFields = new StringBuilder();
            if (!checkModifierParam(field, outForFields)) {
                continue;
            }
            outForFields.append(field.getType().getSimpleName());
            outForFields.append(SPACE);
            outForFields.append(field.getName());
            System.out.println(outForFields);


        }
        Method[] methods = aClass.getDeclaredMethods();
        for (Method method : methods) {
            StringBuilder outForMethods = new StringBuilder();
            if (!checkModifierMethod(method, outForMethods)) {
                continue;
            }
            outForMethods.append(method.getReturnType().getSimpleName()).append(SPACE);
            outForMethods.append(method.getName());
            StringJoiner stringJoiner = getStringParameter(method);
            outForMethods.append(stringJoiner);
            System.out.println(outForMethods);
        }
    }

    private static boolean checkModifierParam(Field field, StringBuilder outForFields) {
        int modifiers = field.getModifiers();
        if (Modifier.isPublic(modifiers)) {
            outForFields.append(PUBLIC_);
        } else {
            return false;
        }
        if (Modifier.isPrivate(modifiers)) {
            outForFields.append(PRIVATE_);
        }
        if (Modifier.isProtected(modifiers)) {
            outForFields.append(PROTECTED_);
        }
        if (Modifier.isStatic(modifiers)) {
            outForFields.append(STATIC_);
        }
        return true;
    }

    private static boolean checkModifierMethod(Method method, StringBuilder outForMethods) {
        int modifiers = method.getModifiers();
        if (Modifier.isPublic(modifiers)) {
            outForMethods.append(PUBLIC_);
        } else {
            return false;
        }
        if (Modifier.isPrivate(modifiers)) {
            outForMethods.append(PRIVATE_);
        }
        if (Modifier.isProtected(modifiers)) {
            outForMethods.append(PROTECTED_);
        }
        if (Modifier.isStatic(modifiers)) {
            outForMethods.append(STATIC_);
        }
        return true;
    }

    private static StringJoiner getStringParameter(Method method) {
        Class<?>[] parameterTypes = method.getParameterTypes();
        StringJoiner stringJoiner = new StringJoiner(DELIMITER, PREFIX, SUFFIX);
        for (Class<?> parameterType : parameterTypes) {
            stringJoiner.add(parameterType.getSimpleName());
        }
        return stringJoiner;
    }

}
