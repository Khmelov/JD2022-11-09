package by.it.cherny.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Scalar var = new Scalar(1.1);
        Var var1 = new Scalar(2);
        Var var2 = new Scalar("3.333");
        double[][] doubles = {{1,2},{3,4}};
        String s = "{{1,2},{3,4}}";
        Var var5 = new Matrix(s);
        System.out.println(var5);
    }
}
