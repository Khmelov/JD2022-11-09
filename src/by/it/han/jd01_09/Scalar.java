package by.it.han.jd01_09;

public class Scalar extends Var {

    private final double value;

    public Scalar(double value) {
        this.value = value;
    }

    public Scalar(Scalar scalar) {
        this.value = scalar.value;
    }

    public Scalar(String strScalar) {
        this.value = Double.parseDouble(strScalar);
    }

    public double getValue() {
        return value;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar scalar) {
            return new Scalar(this.value + scalar.value);
        } else if (other instanceof Vector vector) {
            double[] result = new double[vector.getValue().length];
            for (int i = 0; i < vector.getValue().length; i++) {
                result[i] = this.value + vector.getValue()[i];
            }
            return new Vector(result);
        } else if (other instanceof Matrix matrix) {
            double[][] result = new double[matrix.getValue().length][matrix.getValue()[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    result[i][j] = this.value + matrix.getValue()[i][j];
                }
            }
            return new Matrix(matrix);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar scalar) {
            return new Scalar(this.value - scalar.value);
        } else if (other instanceof Vector vector) {
            double[] result = new double[vector.getValue().length];
            for (int i = 0; i < vector.getValue().length; i++) {
                result[i] = this.value - vector.getValue()[i];
            }
            return new Vector(result);
        } else if (other instanceof Matrix matrix) {
            double[][] result = new double[matrix.getValue().length][matrix.getValue()[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    result[i][j] = this.value - matrix.getValue()[i][j];
                }
            }
            return new Matrix(matrix);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar scalar) {
            return new Scalar(this.value * scalar.value);
        } else if (other instanceof Vector vector) {
            vector.mul(this);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar scalar && scalar.value != 0) {
            return new Scalar(this.value / scalar.value);
        } else if (other instanceof Vector vector) {
            vector.mul(this);
        }
        return super.div(other);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
