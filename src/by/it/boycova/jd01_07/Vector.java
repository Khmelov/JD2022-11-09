package by.it.boycova.jd01_07;

import java.util.Arrays;

public class Vector extends Var{

    private final double[] values;

    public Vector(double[] values) {
        this.values = values;
    }

    public Vector(Vector var4) {
        this.values=var4.values;
    }


    public Vector(String strVector) {
        String str=strVector.replaceAll("[\\{\\}]","");
        String []array=str.trim().split(",");
        double[]arr=new double[array.length];
        for (int i = 0; i < array.length; i++) {
            arr[i]=Double.parseDouble(array[i]);
        }
        this.values=arr;
    }

    @Override
    public String toString() {
        String line= Arrays.toString(values).replaceAll("[\\[\\]]","");
        return "{"+line+"}";
    }
}
