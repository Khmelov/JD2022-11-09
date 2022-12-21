package by.it.vasileuskaya.calc;

class Matrix extends Var {
    private double[][] values;

    public Matrix(double[][] value) {
        this.values = value;
    }

    public Matrix(String values) {
    }

    @Override
    public String toString() {
        return "Matrix{}";
    }
}
