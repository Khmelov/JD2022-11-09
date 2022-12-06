package by.it.cherny.jd01_08;

import java.util.Arrays;
import java.util.StringJoiner;

public class Vector extends Var {
    private final double[] values;

    public Vector(double[] values){
        this.values = values.clone();
    }

    public Vector(Vector values){
        this.values = values.values.clone();
    }

    public Vector(String strings){
        String[] array = strings
                .replaceAll("[{}\\s]+","")
                .split(",");
        values=new double[array.length];
        for (int i = 0; i < values.length; i++) {
            values[i]=Double.parseDouble(array[i]);
        }
    }

    @Override
    public Var add(Var other) {
        double[] temp = values.clone();
        if (other instanceof Scalar scalar){
            for (int i = 0; i < temp.length; i++) {
                temp[i]+=scalar.getValue();
            }
            return new Vector(temp);
        }
        if (other instanceof Vector vector){
            for (int i = 0; i < temp.length; i++) {
                temp[i]+=vector.values[i];
            }
            return new Vector(temp);
        }
        return super.add(other);
    }

    @Override
//    public String toString() {
//        String string = Arrays.toString(values);
//        string = string.substring(1, string.length() - 1);
//        return "{" + string + '}';
//    }
    public String toString(){
        StringJoiner out = new StringJoiner(", ", "{", "}");
        for (double value : values) {
            out.add(String.valueOf(value));
        }
        return out.toString();
    }
}
