package by.it.bolshakov.jd01_07;

public class Vector extends Var {
    private final double[] values;

    public Vector(double[] values) {
        this.values = values.clone();
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
        this.values = values.getValues().clone();
    }

    public double[] getValues() {
        return this.values;
    }

    @Override
    public String toString() {
        StringBuffer vals = new StringBuffer();
        vals.append("{");
        for (int i = 0; i < values.length; i++) {
            vals.append(values[i]);
            if (i!= values.length-1) vals.append(", ");
        }
        vals.append("}");
        return vals.toString();
    }
}
