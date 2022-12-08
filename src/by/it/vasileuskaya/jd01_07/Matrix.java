package by.it.vasileuskaya.jd01_07;

public class Matrix extends Var {
    private final double[][] value;


    public Matrix(double[][] value) {
        this.value = value;
    }

    public Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    public Matrix(String strMatrix) {
        this.value = convertStringToDoubleMatrix(strMatrix);
    }

    private double[][] convertStringToDoubleMatrix(String strMatrix) {
        String str = strMatrix.replace("{", "").replace("}}", "");
        String[] matrixStr = str.split("},\s?");

        return new double[0][];
    }
}
