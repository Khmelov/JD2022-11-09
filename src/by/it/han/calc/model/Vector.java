package by.it.han.calc.model;

import by.it.han.calc.exception.VarException;

import static by.it.han.jd01_07.Vector.convertToVector;
import static by.it.han.jd01_07.Vector.getString;

public class Vector extends Var {

    private final double[] value;

    public Vector(double[] value) {
        this.value = value;
    }

    public Vector(Vector vector) {
        this.value = vector.value;
    }

    public Vector(String strVector) {
        this.value = convertToVector(strVector);
    }

    public double[] getValue() {
        return value;
    }

    @Override
    public Var add(Var other) {
        double[] cloneValue = this.value.clone();
        if (other instanceof Vector vector) {
            for (int i = 0; i < vector.value.length; i++) {
                cloneValue[i] += vector.value[i];
            }
            return new Vector(cloneValue);
        } else if (other instanceof Scalar scalar) {
            for (int i = 0; i < cloneValue.length; i++) {
                cloneValue[i] += scalar.getValue();
            }
            return new Vector(cloneValue);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        double[] cloneValue = this.value.clone();
        if (other instanceof Vector vector && vector.value.length == this.value.length) {
            for (int i = 0; i < vector.value.length; i++) {
                cloneValue[i] -= vector.value[i];
            }
            return new Vector(cloneValue);
        } else if (other instanceof Scalar scalar) {
            for (int i = 0; i < cloneValue.length; i++) {
                cloneValue[i] -= scalar.getValue();
            }
            return new Vector(cloneValue);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        double[] cloneValue = this.value.clone();
        double result = 0;
        if (other instanceof Vector vector && vector.value.length == this.value.length) {
            for (int i = 0; i < vector.value.length; i++) {
                result += cloneValue[i] * vector.value[i];
            }
            return new Scalar(result);
        } else if (other instanceof Scalar scalar) {
            for (int i = 0; i < cloneValue.length; i++) {
                cloneValue[i] *= scalar.getValue();
            }
            return new Vector(cloneValue);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) throws VarException {
        if (other instanceof Scalar scalar) {
            if (scalar.getValue() == 0.0) {
                throw new VarException(Var.resMan.get(Error.incorrectData), resMan);
            }
            double[] cloneValue = this.value.clone();
            for (int i = 0; i < cloneValue.length; i++) {
                cloneValue[i] /= scalar.getValue();
            }
            return new Vector(cloneValue);
        }
        return super.div(other);
    }

    @Override
    public String toString() {
        return getString(value);
    }
}
