package by.it.bolshakov.jd01_07;

public class Scalar extends Var {
    private final double value;

    public Scalar(double value) {
        this.value = value;
    }

    public Scalar(Scalar scalar) {
        this.value = Double.parseDouble(scalar.toString());
    }

    public Scalar(String StrScalar) {
        this.value = Double.parseDouble(StrScalar);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
