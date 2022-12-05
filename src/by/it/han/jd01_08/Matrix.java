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
    public Var add(Var other) {
        double[][] result = new double[this.value.length][this.value[0].length];
        if (other instanceof Matrix matrix && matrix.value.length == this.value.length) {
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[i].length; j++) {
                    result[i][j] = this.value[i][j] + matrix.value[i][j];
                }
            }
            return new Matrix(result);
        } else if (other instanceof Scalar scalar) {
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[i].length; j++) {
                    result[i][j] = this.value[i][j] + scalar.getValue();
                }
            }
            return new Matrix(result);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        double[][] result = new double[this.value.length][this.value[0].length];
        if (other instanceof Matrix matrix && matrix.value.length == this.value.length) {
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[i].length; j++) {
                    result[i][j] = this.value[i][j] - matrix.value[i][j];
                }
            }
            return new Matrix(result);
        } else if (other instanceof Scalar scalar) {
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[i].length; j++) {
                    result[i][j] = this.value[i][j] - scalar.getValue();
                }
            }
            return new Matrix(result);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        double[][] result = new double[this.value.length][this.value[0].length];
        if (other instanceof Scalar scalar && scalar.getValue() != 0) {
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[i].length; j++) {
                    result[i][j] = this.value[i][j] / scalar.getValue();
                }
            }
            return new Matrix(result);
        }
        return super.div(other);
    }

    @Override
    public String toString() {
        return getString(value);
    }
}
