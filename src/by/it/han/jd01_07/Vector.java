package by.it.han.jd01_07;

public class Vector extends Var {

    private final double[] value;

    public Vector(double[] value) {
        this.value = value;
    }

    public Vector(Vector vector) {
        this.value = vector.value;
    }

    public Vector(String strVector) {
        this.value = convertToVector(strVector);
    }

    public static double[] convertToVector(String strVector) {
        String[] strings = strVector.replace("{", "")
                .replace("}", "")
                .split(",");
        double[] vector = new double[strings.length];
        for (int i = 0; i < vector.length; i++) {
            vector[i] = Double.parseDouble(strings[i]);
        }
        return vector;
    }

    @Override
    public String toString() {
        return getString(value);
    }

    public static String getString(double[] value) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < value.length; i++) {
            sb.append(value[i]);
            if (i != value.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }
}
