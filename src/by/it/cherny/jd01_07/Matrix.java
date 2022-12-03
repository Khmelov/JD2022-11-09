package by.it.cherny.jd01_07;

import java.util.Arrays;

public class Matrix extends Var{
    private final double[][] value;

    public Matrix(double[][] value) {
        this.value = value;
    }
    public Matrix(Matrix matrix) {
        this.value = matrix.value;
    }
    public Matrix(String strMatrix) {
        strMatrix=strMatrix.substring(2,strMatrix.length()-2);
        String[] strings = strMatrix.split("},\\{");
        this.value = new double[strings.length][strings[0].split(",").length];
        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings[0].split(",").length; j++) {
                String[] str1 = strings[i].split(",");
                this.value[i][j]=Double.parseDouble(str1[j]);
            }
        }
    }

    @Override
    public String toString() {
        String str = Arrays.deepToString(value);
        str = str.replaceAll("\\[","{")
                .replaceAll("]","}");
        return str;
    }
}
