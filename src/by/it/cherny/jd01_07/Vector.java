package by.it.cherny.jd01_07;

import java.util.Arrays;

public class Vector extends Var{
    private final double[] value;

    public Vector(double[] value){
        this.value = value.clone();
    }
    public Vector(Vector vector){
        this.value = vector.value;
    }
    public Vector(String strVector){
        strVector = strVector.substring(1,strVector.length()-1);
        System.out.println(strVector);
        String[] strings = strVector.split(",");
        this.value = new double[strings.length];
        for (int i = 0; i < strings.length; i++) {
            this.value[i]=Double.parseDouble(strings[i]);
        }
    }

    @Override
    public String toString() {
        String string = Arrays.toString(value);
        string = string.substring(1,string.length()-1);
        return "{" + string +'}';
    }
}
