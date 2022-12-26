package by.it.vasileuskaya.calc;

class Scalar extends Var {
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
    public String toString() {
        return String.valueOf(this.value);
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            Scalar scalarTemp = (Scalar) other;
            return new Scalar(this.value + scalarTemp.value);
        } else {
            return other.add(this);
        }
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            Scalar scalarTemp = (Scalar) other;
            return new Scalar(this.value - scalarTemp.value);
        }
        Scalar minus = new Scalar(-1);
        return minus.mul(other.sub(this));
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            Scalar scalarTemp = (Scalar) other;
            return new Scalar(this.value * scalarTemp.value);
        }
        return other.mul(this);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            Scalar scalarTemp = (Scalar) other;
            if (scalarTemp.value == 0) {
                throw new CalcException("Division by zero");
            }
            return new Scalar(this.value / scalarTemp.value);
        }
        return super.div(other);
    }
}


