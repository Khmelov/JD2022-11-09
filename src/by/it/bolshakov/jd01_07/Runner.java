package by.it.bolshakov.jd01_07;

public class Runner {
    public static void main(String[] args) {
        double[] test1 = {1.2, 2.0, 3.827};
        String test2 =  "{1,2,4}";
        Vector var = new Vector(test2);
        Var var2 = new Vector(var);
        System.out.println(var2);
    }
}
