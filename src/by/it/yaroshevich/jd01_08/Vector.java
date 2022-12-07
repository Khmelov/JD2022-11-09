package by.it.yaroshevich.jd01_08;

import java.util.Arrays;
import java.util.StringJoiner;

public class Vector extends Var {

    private final double[] values;

    public Vector(double[] values) {

        this.values = values.clone();
    }

    public Vector(Vector vector) {

        this.values = vector.values.clone();
    }

    public Vector(String string){
        String [] array = string
                .replaceAll("[{}\\s]+", "")
                .split(",");
        values=new double[array.length];
        for (int i = 0; i < values.length; i++) {
            values[i] = Double.parseDouble((array[i]));
        }
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(",", "{", "}");
        for (double value : values){
            out.add(String.valueOf(value));
        }
        return out.toString();
    }

}