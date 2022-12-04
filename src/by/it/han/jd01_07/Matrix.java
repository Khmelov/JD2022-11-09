package by.it.han.jd01_07;

public class Matrix extends Var {

    private final double[][] value;

    public Matrix(double[][] value) {
        this.value = value;
    }

    public Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    public Matrix(String strMatrix) {
        this.value = convertToMatrix(strMatrix);
    }

    private double[][] convertToMatrix(String strMatrix) {
        String[] matrixArray = strMatrix
                .replace("{", "")
                .replace("\s", "")
                .split("}");
        for (int i = 0; i < matrixArray.length; i++) {
            matrixArray[i] = matrixArray[i].replace(",", " ");
        }
        int countColumn = matrixArray[0]
                .trim()
                .split(" ").length;
        double[][] matrix = new double[matrixArray.length][countColumn];
        for (int i = 0; i < matrix.length; i++) {
            String[] values = matrixArray[i]
                    .trim()
                    .split(" ");
            for (int j = 0; j < values.length; j++) {
                String val = values[j].trim();
                matrix[i][j] = Double.parseDouble(val);
            }
        }
        return matrix;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < value.length; i++) {
            sb.append("{");
            for (int j = 0; j < value[i].length; j++) {
                sb.append(value[i][j]);
                if (j != value[i].length - 1) {
                    sb.append(",");
                }
            }
            sb.append("}");
            if (i != value.length - 1) {
                sb.append(",");
            }
        }
        sb.append("}");
        return sb.toString();
    }
}
