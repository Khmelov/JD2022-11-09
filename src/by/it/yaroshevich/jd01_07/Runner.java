package by.it.yaroshevich.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Scalar var1 = new Scalar(1.1);
        Var var2 = new Scalar(var1);
        Var var3 = new Scalar("3.333");
        System.out.println(var1);
        System.out.println(var2);
        System.out.println(var3);
    }
}
