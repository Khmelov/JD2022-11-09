package by.it.yaroshevich.jd01_08;

public class Matrix  extends Var{

    private double[][] values;

    public Matrix(double[][] values){
        this.values = values;
    }

    public Matrix(String values){

    }

    @Override
    public Var add(Var other) {
        return null;
    }

    @Override
    public Var sub(Var other) {
        return null;
    }

    @Override
    public Var mul(Var other) {
        return null;
    }

    @Override
    public Var div(Var other) {
        return null;
    }

    @Override
    public String toString() {
        return "Matrix{ }";
    }
}
