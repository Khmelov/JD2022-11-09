package by.it.yaroshevich.jd01_07;

import java.util.Arrays;
import java.util.Comparator;

public class Runner {
    public static void main(String[] args) {
        Scalar var1 = new Scalar(1.1);
        Var var2 = new Scalar(var1);
        Var var3 = new Scalar("3.333");
        double [] arrays = {1.0, 2.0, 4.0};
        Var var4 = new Vector(arrays);
        Var var5 = new Vector(arrays);
        Var var6 = new Vector("{1.0, 2.0, 4.0}");
        System.out.println(var1);
        System.out.println(var2);
        System.out.println(var3);
        System.out.println(var4);
        System.out.println(var5);
        System.out.println(var6);
    }
}
