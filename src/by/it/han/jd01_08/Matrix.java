package by.it.han.jd01_08;

import static by.it.han.jd01_07.Matrix.convertToMatrix;
import static by.it.han.jd01_07.Matrix.getString;

public class Matrix extends Var {

    private final double[][] value;

    public Matrix(double[][] value) {
        this.value = value;
    }

    public Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    public Matrix(String strMatrix) {
        this.value = convertToMatrix(strMatrix);
    }

    @Override
    public String toString() {
        return getString(value);
    }
}
