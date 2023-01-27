package by.it.vasileuskaya.jd01_07;

public class Matrix extends Var {
    private final double[][] value;


    public Matrix(double[][] value) {
        this.value = value;
    }

    public Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    public Matrix(String strMatrix) {
        this.value = convertStringToDoubleMatrix(strMatrix);
    }

    private double[][] convertStringToDoubleMatrix(String strMatrix) {
        String[] strMatrixInArray = strMatrix
                .substring(2, strMatrix.length() - 2)
                .split("},\s?\\{");
        int countColumn = strMatrixInArray[0].split(",\s?").length;
        int countElementsInRows = strMatrixInArray[0].split(",\s?").length;
        double[][] matrixDouble = new double[strMatrixInArray.length][countColumn];
        for (int i = 0; i < matrixDouble.length; i++) {
            for (int j = 0; j < countElementsInRows; j++) {
                String[] strArrayTemp = strMatrixInArray[i].split(",\s?");
                matrixDouble[i][j] = Double.parseDouble(strArrayTemp[j]);
            }
        }
        return matrixDouble;
    }

    @Override
    public String toString() {
        StringBuilder matrixString = new StringBuilder("{");
        for (double[] doubles : value) {
            matrixString.append("{");
            for (double aDouble : doubles) {
                matrixString.append(aDouble).append(", ");
            }
            matrixString
                    .delete(matrixString.length() - 2, matrixString.length())
                    .append("}, ");
        }
        matrixString
                .delete(matrixString.length() - 2, matrixString.length())
                .append("}");
        return matrixString.toString();
    }
}
