package by.it.boycova.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Scalar var1 = new Scalar(3.1415);
        Var var2 = new Scalar(var1);
        Var var3 = new Scalar("3.1415");

        Vector var4=new Vector(new double[]{1.0, 2.0, 4.0});
        Var var5=new Vector(var4);
        Var var6=new Vector("{1.0, 2.0, 4.0}");

        Matrix var7=new Matrix(new double[][]{{1.0,2.0},{3.0,4.0}});
        Var var8= new Matrix(var7);
        Var var9= new Matrix("{{1.0,2.0},{3.0,4.0}}");
    }
}
