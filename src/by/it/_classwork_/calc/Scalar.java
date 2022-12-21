package by.it._classwork_.calc;

class Scalar extends Var {

    private final double value;

    public Scalar(double value) {
        this.value = value;
    }

    public Scalar(String stringValue) {
        this.value = Double.parseDouble(stringValue);
    }

    public Scalar(Scalar otherScalar) {
        this.value = otherScalar.value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public Var add(Var other) {
        //1 operand == this 2 operand == ????
        if (other instanceof Scalar second) {
            return new Scalar(this.value + second.value);
        } else {
            Var res = other.add(this);
            return res;
        }
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar second) {
            return new Scalar(this.value - second.value);
        }
        Scalar minus = new Scalar(-1);
        return minus.mul(other.add(this));
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar second) {
            return new Scalar(this.value * second.value);
        }
        return other.add(this);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar second) {
            return new Scalar(this.value / second.value);
        }
        return super.div(other);
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}
