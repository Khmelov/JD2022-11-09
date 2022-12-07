package by.it.bolshakov.jd01_08;

public class Scalar extends Var {
    private final double value;

    public Scalar(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
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

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar second) {
            return new Scalar(this.value + second.value);
        }
        return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar second) {
            return new Scalar(this.value - second.value);
        }
        Scalar minus = new Scalar(-1);
        return minus.mul(other.sub(this));
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar second) {
            return new Scalar(this.value * second.value);
        }
        return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar second) {
            return new Scalar(this.value / second.value);
        }
        return other.div(this);
    }
}
