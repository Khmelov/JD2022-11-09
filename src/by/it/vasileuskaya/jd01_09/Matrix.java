package by.it.vasileuskaya.jd01_09;

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
