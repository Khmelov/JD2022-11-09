package by.it.bolshakov.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {
        System.out.println(getClassPublicMethods(Math.class));
        System.out.println(getClassPublicFields(Math.class));
    }
    static String getClassPublicMethods(Class<?> c) {
        StringBuffer strOutput = new StringBuffer();
        for (Method method : c.getDeclaredMethods()){
            if ((method.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC) {
                strOutput.append(Modifier.toString(method.getModifiers()));
                strOutput.append(" ");
                strOutput.append(method.getReturnType() + " ");
                strOutput.append(method.getName() + "(");
                String comma="";
                for (Class<?> param : method.getParameterTypes()) {
                    strOutput.append(comma + param);
                    comma=",";
                }
                strOutput.append(")");
                strOutput.append("\n");
            }
        }
        return strOutput.toString();
    }

    static String getClassPublicFields(Class<?> c) {
        StringBuffer strOutput = new StringBuffer();
        for (Field field : c.getDeclaredFields()) {
            if ((field.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC) {
                strOutput.append(Modifier.toString(field.getModifiers()));
                strOutput.append(" ");
                strOutput.append(field.getType() + " ");
                strOutput.append(field.getName());
                strOutput.append("\n");
            }
        }
        return strOutput.toString();
    }
}
