package by.it._classwork_.jd01_07;

import java.util.Arrays;

public class Vector extends Var{

    private final double[] values;

    public Vector(double[] values) {
        this.values = values.clone();
    }

    @Override
    public String toString() {
        return "Vector{" +
                "values=" + Arrays.toString(values) +
                '}';
    }
}
