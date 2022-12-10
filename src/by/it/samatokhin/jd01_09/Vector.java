package by.it.samatokhin.jd01_09;

import java.util.StringJoiner;

class Vector extends Var {

    private final double[] values;

    Vector(double[] values) {
        this.values = values;
    }

    Vector(Vector vector) {
        this.values = vector.values.clone();
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
