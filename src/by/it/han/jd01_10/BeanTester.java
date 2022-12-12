package by.it.han.jd01_10;

import java.lang.reflect.Method;

public class BeanTester {

    public static void main(String[] args) throws Exception {
        Class<?> beenClass = Class.forName("by.it.han.jd01_10.Bean");
        for (Method method : beenClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Param.class)) {
                int a = method.getDeclaredAnnotation(Param.class).a();
                int b = method.getDeclaredAnnotation(Param.class).b();
                Object instance = beenClass.getDeclaredConstructor().newInstance();
                System.out.println(method.getName() + ": " + method.invoke(instance, a, b));
            }
        }
    }
}
