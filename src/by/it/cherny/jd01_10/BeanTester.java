package by.it.cherny.jd01_10;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class BeanTester {
    public static void main(String[] args) throws Exception {
//        Bean bean;
        Class<Bean> beanClass = Bean.class;
        for (Method method : beanClass.getDeclaredMethods()) {
            Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
            if (declaredAnnotations.length!=0){
                Annotation annotationName = declaredAnnotations[0];
                Param param = (Param) annotationName;
                Object instance = beanClass.getDeclaredConstructor().newInstance();
                System.out.println(method.getName());
                if (method.getModifiers() == Modifier.STATIC){
                    System.out.println(method.invoke(null, param.a(), param.b()));
                } else {
                    System.out.println(method.invoke(instance, param.a(), param.b()));
                }
            }
        }
    }
}
