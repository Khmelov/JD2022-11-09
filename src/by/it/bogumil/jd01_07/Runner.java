package by.it.bogumil.jd01_07;

public class Runner {
    public static void main(String[] args) {

        Scalar var1 = new Scalar(3.1415);
        Var var2 = new Scalar(var1);
        Var var3 = new Scalar("3.1415");

        System.out.println(var1);
        System.out.println(var2);
        System.out.println(var3);

        Vector var4 = new Vector(new double[]{1, 2, 4});
        Var var5 = new Vector(var4);
        Var var6 = new Vector("{1.0, 2.0, 4.0}");
        System.out.println(var4);
        System.out.println(var5);
        System.out.println(var6);
    }
}
