package by.it.vasileuskaya.calc.model;

import by.it.vasileuskaya.calc.exception.CalcException;

public class Vector extends Var {
    private final double[] values;

    public Vector(double[] value) {
        this.values = value;
    }

    public Vector(Vector vector) {
        this.values = vector.values;
    }

    public Vector(String strVector) {
        this.values = convertStringToDouble(strVector);
    }

    public double[] getValues() {
        return values;
    }

    private double[] convertStringToDouble(String strVector) {
        String str = strVector.replaceAll("[{}]", "");
        String[] vectors = str.split(",\s?");
        double[] vectorsDouble = new double[vectors.length];
        for (int i = 0; i < vectorsDouble.length; i++) {
            vectorsDouble[i] = Double.parseDouble(vectors[i]);
        }
        return vectorsDouble;
    }

    @Override
    public String toString() {
        StringBuilder vectorString = new StringBuilder("{");
        for (double v : values) {
            vectorString.append(v);
            vectorString.append(", ");
        }
        vectorString.delete(vectorString.length() - 2, vectorString.length());
        vectorString.append("}");
        return vectorString.toString();
    }

    @Override
    public Var add(Var other) throws CalcException {
        double[] temporary = values.clone();
        if (other instanceof Scalar) {
            Scalar scalarTemp = (Scalar) other;
            for (int i = 0; i < temporary.length; i++) {
                temporary[i] += scalarTemp.getValue();
            }
            return new Vector(temporary);
        } else if (other instanceof Vector) {//проверка на размерость
            Vector vectorTemp = (Vector) other;
            if (temporary.length != vectorTemp.values.length) {
                throw new CalcException("Incorrect size of vector %s or %s".formatted(this, vectorTemp));
            }
            for (int i = 0; i < temporary.length; i++) {
                temporary[i] += vectorTemp.values[i];
            }
            return new Vector(temporary);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        double[] temporary = values.clone();
        if (other instanceof Scalar) {
            Scalar scalarTemp = (Scalar) other;
            for (int i = 0; i < temporary.length; i++) {
                temporary[i] -= scalarTemp.getValue();
            }
            return new Vector(temporary);
        } else if (other instanceof Vector) {//проверка на размерость
            Vector vectorTemp = (Vector) other;
            if (temporary.length != vectorTemp.values.length) {
                throw new CalcException("Incorrect size of vector %s or %s".formatted(this, vectorTemp));
            }
            for (int i = 0; i < temporary.length; i++) {
                temporary[i] -= vectorTemp.values[i];
            }
            return new Vector(temporary);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException { //проверка на размерость
        double[] temporary = values.clone();
        if (other instanceof Scalar) {
            Scalar scalarTemp = (Scalar) other;
            for (int i = 0; i < temporary.length; i++) {
                temporary[i] *= scalarTemp.getValue();
            }
            return new Vector(temporary);
        } else if (other instanceof Vector) {//проверка на размерность
            Vector vectorTemp = (Vector) other;
            if (temporary.length != vectorTemp.values.length) {
                throw new CalcException("Incorrect size of vector %s or %s".formatted(this, vectorTemp));
            }
            double result = 0;
            for (int i = 0; i < temporary.length; i++) {
                result += temporary[i] * vectorTemp.values[i];
            }
            return new Scalar(result);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcException {//проверка скаляр=0?
        double[] temporary = values.clone();
        if (other instanceof Scalar) {
            Scalar scalarTemp = (Scalar) other;
            if (scalarTemp.getValue() == 0) {
                throw new CalcException("Division by zero!");
            }
            for (int i = 0; i < temporary.length; i++) {
                temporary[i] /= scalarTemp.getValue();
            }
            return new Vector(temporary);
        } else {
            return super.div(other);
        }
    }
}
