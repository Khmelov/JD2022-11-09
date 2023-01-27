package by.it.han.jd01_09;

public abstract class Var implements Operation {

    public static Var create(String strValue) {
        if (strValue.matches(Patterns.SCALAR)) {
            return new Scalar(strValue);
        } else if (strValue.matches(Patterns.VECTOR)) {
            return new Vector(strValue);
        } else if (strValue.matches(Patterns.MATRIX)) {
            return new Matrix(strValue);
        }
        return null;
    }

    @Override
    public String toString() {
        return "unknownVariable variable";
    }
}
