package by.it.cherny.calc;

import java.util.Arrays;

class Matrix extends Var {
    private double[][] values;
    public Matrix(double[][] values) {
        this.values = values.clone();
    }
    public Matrix(Matrix matrix) {
        this.values = matrix.values.clone();
    }
    public Matrix(String strMatrix) {
//        String str=;
        String[] strings = strMatrix
                .substring(2,strMatrix.length()-2)
                .split("}(,||, )\\{");
        this.values = new double[strings.length][strings[0].split(",").length];
        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings[0].split(",").length; j++) {
                String[] str1 = strings[i].split(",");
                this.values[i][j]=Double.parseDouble(str1[j]);
            }
        }
    }

    @Override
    public Var add(Var other) throws CalcException {
        double[][] temp = values.clone();
        if (other instanceof Scalar scalar){
            for (int i = 0; i < temp.length; i++) {
                for (int j = 0; j < temp[0].length; j++) {
                    temp[i][j]+= scalar.getValue();
                }
            }
            return new Matrix(temp);
        }
        if (other instanceof Matrix matrix){
            double[][] doubles = new double[values[0].length][temp.length];
            if (temp.length == matrix.values[0].length){
                for (int i = 0; i < temp.length; i++) {
                    for (int j = 0; j < temp[0].length; j++) {
                        doubles[i][j]=temp[i][j]+ matrix.values[i][j];
                    }
                }
                return new Matrix(doubles);
            }
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        double[][] temp = values.clone();
        if (other instanceof Scalar scalar){
            for (int i = 0; i < temp.length; i++) {
                for (int j = 0; j < temp[0].length; j++) {
                    temp[i][j]-= scalar.getValue();
                }
            }
            return new Matrix(temp);
        }
        if (other instanceof Matrix matrix){
            double[][] doubles = new double[values[0].length][temp.length];
            if (temp.length == matrix.values[0].length){
                for (int i = 0; i < temp.length; i++) {
                    for (int j = 0; j < temp[0].length; j++) {
                        doubles[i][j]=temp[i][j]-matrix.values[i][j];
                    }
                }
                return new Matrix(doubles);
            }
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        double[][] temp = values.clone();
        if (other instanceof Scalar scalar){
            for (int i = 0; i < temp.length; i++) {
                for (int j = 0; j < temp[0].length; j++) {
                    temp[i][j]*= scalar.getValue();
                }
            }
            return new Matrix(temp);
        }
        if (other instanceof Matrix matrix){
            if (temp.length == matrix.values[0].length) {
                double[][] result = new double[temp.length][matrix.values[0].length];
                for (int i = 0; i < temp.length; i++) {
                    for (int j = 0; j < matrix.values[0].length; j++) {
                        for (int k = 0; k < matrix.values.length; k++) {
                            result[i][j] += temp[i][k] * matrix.values[k][j];
                        }
                    }
                }
                return new Matrix(result);
            }
        }
        if (other instanceof Vector vector){
            if (values.length == temp[0].length){
                double[] values = vector.getValues();
                double[] res = new double[temp.length];
                for (int i = 0; i < temp.length; i++)
                    for (int j = 0; j < temp[0].length; j++)
                        res[i] += temp[i][j] * values[j];
//                System.out.println(Arrays.toString(res).replaceAll("\\[", "[["));
                return new Matrix(Arrays.toString(res).replaceAll("\\[", "[["));
            }
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        double[][] temp = values.clone();
        if (other instanceof Scalar scalar){
            if (scalar.getValue()!=0){
                for (int i = 0; i < temp.length; i++) {
                    for (int j = 0; j < temp[0].length; j++) {
                        temp[i][j]/= scalar.getValue();
                    }
                }
                return new Matrix(temp);
            }
        }
        return super.div(other);
    }
    String s = "[[17.0, 39.0]]";
    @Override
    public String toString() {
        String str = Arrays.deepToString(values);
        if (values.length!=1){
            System.out.println(str);
            str = str.replaceAll("\\[","{")
                    .replaceAll("]","}");
            return str;
        }
        return str.replaceAll("\\[+","{").replaceAll("]+", "}");
    }
}
