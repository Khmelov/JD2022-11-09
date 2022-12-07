package by.it.bolshakov.jd01_08;

import java.util.StringJoiner;

public class Vector extends Var {
    private final double[] values;

    public Vector(double[] values) {
        this.values = values.clone();
    }

    public double[] getValues() {
        return values;
    }

    public Vector(String strValues) {
        strValues = strValues.replaceAll("[{|}]","");
        String[] splitVals = strValues.split(",");
        double[] vals = new double[splitVals.length];
        for (int i = 0; i < splitVals.length; i++) {
            vals[i] = Double.parseDouble(splitVals[i].trim());
        }
        this.values = vals.clone();
    }

    public Vector(Vector values) {
        this.values = values.values.clone();
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(", ", "{", "}");
        for (double val: values) {
            out.add(String.valueOf(val));
        }
        return out.toString();
    }

    @Override
    public Var add(Var other) {
        double[] tmp = values.clone();
        if (other instanceof Scalar second) {
            for (int i = 0; i < tmp.length; i++) {
                tmp[i]+=second.getValue();
            }
            return new Vector(tmp);
        } else if (other instanceof Vector second) {
           if (tmp.length==second.values.length){
               for (int i = 0; i < tmp.length; i++) {
                   tmp[i]+=second.values[i];
               }
           }
           return new Vector(tmp);
        }
        return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        double[] tmp = values.clone();
        if (other instanceof Scalar second) {
            for (int i = 0; i < tmp.length; i++) {
                tmp[i]-=second.getValue();
            }
            return new Vector(tmp);
        } else if (other instanceof Vector second) {
            if (tmp.length==second.values.length){
                for (int i = 0; i < tmp.length; i++) {
                    tmp[i]-=second.values[i];
                }
            }
            return new Vector(tmp);
        }
        return other.add(this);
    }

    @Override
    public Var mul(Var other) {
        double[] tmp = values.clone();
        if (other instanceof Scalar second) {
            for (int i = 0; i < tmp.length; i++) {
                tmp[i] *= second.getValue();
            }
            return new Vector(tmp);
        } else if (other instanceof Vector second) {
            if (tmp.length==second.values.length) {
                double sum = 0;
                for (int i = 0; i < tmp.length; i++) {
                    sum+=tmp[i]*second.values[i];
                }
                return new Scalar(sum);
            }
        }
        return other.add(this);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar second) {
            double[] tmp = values.clone();
            for (int i = 0; i < tmp.length; i++) {
                tmp[i]/= second.getValue();
            }
            return new Vector(tmp);
        } else return super.div(other);
    }
}
