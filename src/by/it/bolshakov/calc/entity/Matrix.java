package by.it.bolshakov.calc.entity;

public class Matrix extends Var {

    private double[][] values;

    public Matrix(double[][] values) {
        this.values = values;
    }

    public Matrix(String values) {
    }

    @Override
    public String toString() {
        return "Matrix{ }";
    }
}
