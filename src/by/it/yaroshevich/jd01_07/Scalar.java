package by.it.yaroshevich.jd01_07;

public class Scalar extends Var{
    private final double value;

    public Scalar (double value) {
        this.value = value;

    }
    public Scalar (String stringValue) {
        this.value = Double.parseDouble(stringValue);

    }

    public Scalar(Scalar otherScalar) {
        this.value=otherScalar.value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
