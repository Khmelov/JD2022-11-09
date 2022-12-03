package by.it.han.jd01_08;

public class Scalar extends Var {

    private final double value;

    public Scalar(double value) {
        this.value = value;
    }

    public Scalar(Scalar scalar) {
        this.value = scalar.value;
    }

    public Scalar(String strScalar) {
        this.value = Double.parseDouble(strScalar);
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar scalar) {
            return new Scalar(this.value + scalar.value);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar scalar) {
            return new Scalar(this.value - scalar.value);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar scalar) {
            return new Scalar(this.value * scalar.value);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar scalar) {
            return new Scalar(this.value / scalar.value);
        }
        return super.div(other);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
