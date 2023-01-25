package by.it.han.calc.model;

import by.it.han.calc.exception.VarException;

import static by.it.han.jd01_03.Helper.multiply;
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

    public double[][] getValue() {
        return value;
    }

    @Override
    public Var add(Var other) {
        double[][] result = new double[this.value.length][this.value[0].length];
        if (other instanceof Matrix matrix && matrix.getValue().length == this.value.length) {
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[i].length; j++) {
                    result[i][j] = this.value[i][j] + matrix.getValue()[i][j];
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
        if (other instanceof Matrix matrix && matrix.getValue().length == this.value.length) {
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[i].length; j++) {
                    result[i][j] = this.value[i][j] - matrix.getValue()[i][j];
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
        double[][] result = new double[this.value.length][this.value[0].length];
        if (other instanceof Matrix matrix && matrix.getValue().length == this.value.length) {
            result = multiply(this.value, matrix.value);
            return new Matrix(result);
        } else if (other instanceof Scalar scalar) {
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[i].length; j++) {
                    result[i][j] = this.value[i][j] * scalar.getValue();
                }
            }
            return new Matrix(result);
        } else if (other instanceof Vector vector && this.value[0].length == vector.getValue().length) {
            double[] resultVector = new double[vector.getValue().length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[i].length; j++) {
                    resultVector[i] += this.value[i][j] * vector.getValue()[j];
                }
            }
            return new Vector(resultVector);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) throws VarException {
        double[][] result = new double[this.value.length][this.value[0].length];
        if (other instanceof Scalar scalar) {
            if (scalar.getValue() == 0.0) {
                throw new VarException(Var.resMan.get(Error.incorrectData), resMan);
            }
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
