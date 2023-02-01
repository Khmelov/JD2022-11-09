package by.it.vasileuskaya.jd01_08;

public class Matrix extends Var {

    private final double[][] value;

    public Matrix(double[][] value) {
        this.value = value;
    }

    public Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    public Matrix(String value) {
        this.value = convertStringToDoubleMatrix(value);
    }

    public double[][] getValue() {
        return value;
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

    @Override
    public Var add(Var other) {//если вектор - ошибка
        double[][] temporary = value.clone();
        if (other instanceof Scalar scalarTemp) {
            for (int i = 0; i < temporary.length; i++) {
                for (int j = 0; j < temporary[i].length; j++) {
                    temporary[i][j] += scalarTemp.getValue();
                }
            }
            return new Matrix(temporary);

        } else if (other instanceof Matrix) {//проверка на размерость
            Matrix matrixTemp = (Matrix) other;
            double[][] result = new double[temporary[0].length][temporary.length];
            for (int i = 0; i < temporary.length; i++) {
                for (int j = 0; j < temporary[i].length; j++) {
                    result[i][j] = temporary[i][j] + matrixTemp.getValue()[i][j];
                }
            }
            return new Matrix(result);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {//если вектор - ошибка
        double[][] temporary = value.clone();
        if (other instanceof Scalar) {
            Scalar scalarTemp = (Scalar) other;
            for (int i = 0; i < temporary.length; i++) {
                for (int j = 0; j < temporary[i].length; j++) {
                    temporary[i][j] -= scalarTemp.getValue();
                }
            }
            return new Matrix(temporary);
        } else if (other instanceof Matrix) {//проверка на размерость
            Matrix matrixTemp = (Matrix) other;
            double[][] result = new double[temporary[0].length][temporary.length];
            for (int i = 0; i < temporary.length; i++) {
                for (int j = 0; j < temporary[i].length; j++) {
                    result[i][j] = temporary[i][j] - matrixTemp.getValue()[i][j];
                }
            }
            return new Matrix(result);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        double[][] temporary = value.clone();
        if (other instanceof Scalar) {
            Scalar scalarTemp = (Scalar) other;
            for (int i = 0; i < temporary.length; i++) {
                for (int j = 0; j < temporary[i].length; j++) {
                    temporary[i][j] *= scalarTemp.getValue();
                }
            }
            return new Matrix(temporary);

        } else if (other instanceof Vector) {//проверка на размерость
            Vector vectorTemp = (Vector) other;
            double[] result = new double[temporary.length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < vectorTemp.getValues().length; j++) {
                    result[i] += temporary[i][j] * vectorTemp.getValues()[j];
                }
            }
            return new Vector(result);

        } else if (other instanceof Matrix) {//проверка на размерость
            Matrix matrixTemp = (Matrix) other;
            double[][] result = new double[temporary.length][matrixTemp.getValue()[0].length];
            for (int i = 0; i < temporary.length; i++) {
                for (int j = 0; j < matrixTemp.getValue()[0].length; j++) {
                    for (int m = 0; m < matrixTemp.getValue().length; m++) {
                        result[i][j] += temporary[i][m] * matrixTemp.getValue()[m][j];
                    }
                }
            }
            return new Matrix(result);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {//если матрица или вектор - ошибка
        double[][] temporary = value.clone(); // проверка - деление на ноль
        if (other instanceof Scalar) {
            Scalar scalarTemp = (Scalar) other;
            for (int i = 0; i < temporary.length; i++) {
                for (int j = 0; j < temporary[i].length; j++) {
                    temporary[i][j] /= scalarTemp.getValue();
                }
            }
            return new Matrix(temporary);
        }
        return super.div(other);
    }
}
