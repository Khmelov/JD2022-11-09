package by.it.boycova.jd01_07;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matrix extends Var {

    private final double[][]values;

    public Matrix(double[][] values) {
        this.values = values;
    }

    public Matrix(Matrix var7) {
        this.values = var7.values;
    }

    public Matrix(String stringMatrix) {
        StringBuilder line= new StringBuilder(stringMatrix);
        line.deleteCharAt(0).deleteCharAt(line.length()-1);
        int counter=0;
        Pattern pattern= Pattern.compile("[\\{]");
        Matcher matcher= pattern.matcher(line);
        while(matcher.find()) {
            counter++;
            }
        String sentence= new String(line);
        String [] arr= sentence.replaceAll("[\\{\\} ]","").trim().split(",");
        int x=0;
        double [][]array= new double[counter][counter];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j]=Double.parseDouble(arr[x]);
                x++;
            }
        }
        this.values = array;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder= new StringBuilder();
        stringBuilder.append("{");
        for (int i = 0; i < values.length; i++) {
            stringBuilder.append("{");
            for (int j = 0; j < values.length; j++) {
               stringBuilder.append(values[i][j]);
               if(j!=values[i].length-1){
                   stringBuilder.append(",");

               }else stringBuilder.append("}");
            }
            if (i!= values.length-1){
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
