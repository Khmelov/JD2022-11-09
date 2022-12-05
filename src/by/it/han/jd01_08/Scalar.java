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

    public double getValue() {
        return value;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar scalar) {
            return new Scalar(this.value + scalar.value);
        } else if (other instanceof Vector vector) {
            vector.add(this);
        } else if (other instanceof Matrix matrix) {
            matrix.add(this);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar scalar) {
            return new Scalar(this.value - scalar.value);
        } else if (other instanceof Vector vector) {
            vector.sub(this);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar scalar) {
            return new Scalar(this.value * scalar.value);
        } else if (other instanceof Vector vector) {
            vector.mul(this);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar scalar && scalar.value != 0) {
            return new Scalar(this.value / scalar.value);
        } else if (other instanceof Vector vector) {
            vector.mul(this);
        }
        return super.div(other);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
