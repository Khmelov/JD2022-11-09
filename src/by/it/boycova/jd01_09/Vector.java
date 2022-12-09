package by.it.boycova.jd01_09;

import java.util.Arrays;

 class Vector extends Var {

    private final double[] values;

    public Vector(double[] values) {
        this.values = values;
    }
    public Vector(Vector vector) {
        this.values=vector.values;
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
    public Var add(Var other) {
        if(other instanceof Scalar scalar){
            double[] arrayVector = values.clone();
            for (int i = 0; i < arrayVector.length; i++) {
                arrayVector[i]= arrayVector[i]+scalar.getValue();
            }
            return new Vector(arrayVector);
        }
        else if (other instanceof Vector vector  && this.values.length==vector.values.length){
            double[] arrayVector = values.clone();
            for (int i = 0; i < arrayVector.length; i++) {
                arrayVector[i]= arrayVector[i]+vector.values[i];
            }
            return new Vector(arrayVector);
        }
        else {
            return super.add(other);
        }
    }

    @Override
    public Var sub(Var other) {
        double[] arrayVector = values.clone();
        if(other instanceof Scalar scalar){
            for (int i = 0; i < arrayVector.length; i++) {
                arrayVector[i]= arrayVector[i]-scalar.getValue();
            }
            return new Vector(arrayVector);
        }
        else if (other instanceof Vector vector && this.values.length==vector.values.length){
            for (int i = 0; i < arrayVector.length; i++) {
                arrayVector[i]=arrayVector[i]-vector.values[i];
            }
            return new Vector(arrayVector);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        double[] arrayVector = values.clone();
        if(other instanceof Scalar scalar){
            for (int i = 0; i < arrayVector.length; i++) {
                arrayVector[i]= arrayVector[i]*scalar.getValue();
            }
            return new Vector(arrayVector);
        }
        else if (other instanceof Vector vector && this.values.length==vector.values.length) {
            double result=0;
            for (int i = 0; i < arrayVector.length; i++) {
                result = result+ arrayVector[i]*vector.values[i];
            }
            return new Scalar(result);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        double[] arrayVector = values.clone();
        if(other instanceof Scalar scalar && scalar.getValue()!=0){
            for (int i = 0; i < arrayVector.length; i++) {
                arrayVector[i]= arrayVector[i]/scalar.getValue();
            }
            return new Vector(arrayVector);
        }
        return super.div(other);
    }

    @Override
    public String toString() {
        String line= Arrays.toString(values).replaceAll("[\\[\\]]","");
        return "{"+line+"}";
    }
}














   // public Vector(Vector var4) {
    //    this.values=var4.values;
    //}

/*
    public Vector(String strVector) {
        String str=strVector.replaceAll("[\\{\\}]","");
        String []array=str.trim().split(",");
        double[]arr=new double[array.length];
        for (int i = 0; i < array.length; i++) {
            arr[i]=Double.parseDouble(array[i]);
        }
        this.values=arr;
    }

 */


