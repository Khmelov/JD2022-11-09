package by.it.yaroshevich.jd01_07;

import java.util.Arrays;

public class Vector extends Var{

    private final double[] values;

    public Vector(double[] values) {

        this.values = values.clone();
    }

    public Vector(Vector vector) {

        this.values=vector.values;
    }

    public Vector(String string){

        this.values=string(string);
    }

    private double[] string(String strVector) {
        String str = strVector.replaceAll("[{}]", "");
        String[] vectors = str.split(",\\s?");
        double[] arrayDouble = new double[vectors.length];
        for (int i = 0; i < arrayDouble.length; i++) {
            arrayDouble[i] = Double.parseDouble((vectors[i]));
        }
        return arrayDouble;
    }

    @Override
    public String toString() {

        return Arrays.toString(values).replace("[", "{").replace("]", "}");
    }

}