package by.it.bolshakov.calc.entity;

import by.it.bolshakov.calc.exception.CalcException;

import java.util.StringJoiner;

public class Vector extends Var {

    private final double[] values;

    public Vector(double[] values) {
        this.values = values.clone();
    }

    public Vector(Vector vector) {
        this.values = vector.values.clone();
    }

    @Override
    public Var add(Var other) throws CalcException {
        double[] temp = values.clone();
        if (other instanceof Scalar scalar) {
            for (int i = 0; i < temp.length; i++) {
                temp[i] += scalar.getValue();
            }
            return new Vector(temp);
        }
        if (other instanceof Vector vector) {
            if (temp.length != vector.values.length) {
                throw new CalcException("incorrect size %s or %s"
                        .formatted(this, vector)
                );
            }
            for (int i = 0; i < temp.length; i++) {
                temp[i] += vector.values[i];
            }
            return new Vector(temp);
        }
        return super.add(other);
    }

    public Vector(String strings) {
        String[] array = strings
                .replaceAll("[{}\\s]+", "")
                .split(",");
        values = new double[array.length];
        for (int i = 0; i < values.length; i++) {
            values[i] = Double.parseDouble(array[i]);
        }
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(", ", "{", "}");
        for (double value : values) {
            out.add(String.valueOf(value));
        }
        return out.toString();
    }
}