package by.it.han.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Scalar scalar = new Scalar(0.111);
        Var scalar2 = new Scalar("1.32132");
        Var scalar3 = new Scalar(scalar);
        System.out.println(scalar);
        System.out.println(scalar2);
        System.out.println(scalar3);

        Vector vector = new Vector(new double[]{1.2, 3.4, 5.2});
        Var vector2 = new Vector(vector);
        Var vector3 = new Vector("{     1,       1,2     }");
        System.out.println(vector);
        System.out.println(vector2);
        System.out.println(vector3);

        Matrix matrix = new Matrix(new double[][]{{1.2, 2.3}, {3.4, 4.5}});
        Var matrix2 = new Matrix(matrix);
        Var matrix3 = new Matrix("{ { 1.0,            2.0 }, {            3.0,        4.0 } }");
        System.out.println(matrix);
        System.out.println(matrix2);
        System.out.println(matrix3);
    }
}
