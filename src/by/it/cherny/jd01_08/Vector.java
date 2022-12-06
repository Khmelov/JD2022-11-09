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
            if (temp.length == vector.values.length){
                for (int i = 0; i < temp.length; i++) {
                    temp[i]+=vector.values[i];
                }
                return new Vector(temp);
            }
        }
        return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        double[] temp = values.clone();
        if (other instanceof Scalar scalar){
            for (int i = 0; i < temp.length; i++) {
                temp[i]-=scalar.getValue();
            }
            return new Vector(temp);
        }
        if (other instanceof Vector vector){
            if (temp.length == vector.values.length){
                for (int i = 0; i < temp.length; i++) {
                    temp[i]-=vector.values[i];
                }
                return new Vector(temp);
            }
        }
        return other.sub(this);
    }

    @Override
    public Var mul(Var other) {
        double[] temp = values.clone();
        if (other instanceof Scalar scalar){
            for (int i = 0; i < temp.length; i++) {
                temp[i]*=scalar.getValue();
            }
            return new Vector(temp);
        }
        if (other instanceof Vector vector){
            if (temp.length == vector.values.length){
                for (int i = 0; i < temp.length; i++) {
                    temp[i]*=vector.values[i];
                }
                double sum = 0;
                for (int i = 0; i < temp.length; i++) {
                    sum+=temp[i];
                }
                return new Vector(String.valueOf(sum));
            }
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        double[] temp = values.clone();
        if (other instanceof Scalar scalar){
            for (int i = 0; i < temp.length; i++) {
                temp[i]/=scalar.getValue();
            }
            return new Vector(temp);
        }
        return super.div(other);
    }

    public double[] getValues() {
        return values;
    }

    public String toString(){
        StringJoiner out = new StringJoiner(", ", "{", "}");
        if (values.length>1){
            for (double value : values) {
                out.add(String.valueOf(value));
            }
            return out.toString();
        }
        return String.valueOf(values[0]).replaceAll("[{}]","");
    }
}
