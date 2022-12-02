package by.it.vasileuskaya.jd01_07;

public class Vector extends Var {
    private final double[] value;

    public Vector(double[] value) {

        this.value = value;
    }

    public Vector(Vector vector) {

        this.value = vector.value;
    }

    public Vector(String strVector) {

        this.value = convertStringToDouble(strVector);
    }

    private double[] convertStringToDouble(String strVector) {
        String str = strVector.replaceAll("[{}]", "");
        String[] vectors = str.split(",\s?");
        double[] vectorsDouble = new double[vectors.length];
        for (int i = 0; i < vectorsDouble.length; i++) {
            vectorsDouble[i] = Double.parseDouble(vectors[i]);
        }
        return vectorsDouble;
    }

    @Override
    public String toString() {
        StringBuilder vectorString = new StringBuilder("{");
        for (double v : value) {
            vectorString.append(v);
            vectorString.append(", ");
        }
        vectorString.delete(vectorString.length() - 2, vectorString.length());
        vectorString.append("}");
        return vectorString.toString();
    }
}
