package by.it.cherny.jd01_07;

public class Scalar extends Var{
    private final double value;

    public Scalar(double value) {
        this.value = value;
    }
    public Scalar(String strScalar) {
        this.value = Double.parseDouble(strScalar);
    }
    public Scalar(Scalar scalar){
        this.value =scalar.value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
