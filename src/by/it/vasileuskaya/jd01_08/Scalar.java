package by.it.vasileuskaya.jd01_08;

public class Scalar extends Var {
    private final double value;


    public double getValue() {
        return value;
    }

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
    public String toString() {
        return Double.toString(value);
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            Scalar scalarTemp = (Scalar) other;
            Scalar resultVar = new Scalar(this.value + scalarTemp.value);
            return resultVar;
        }
        return other.add(this);//будет искать метод в предке
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            Scalar scalarTemp = (Scalar) other;
            Scalar resultVar = new Scalar(this.value - scalarTemp.value);
            return resultVar;
        } else {
            Scalar minus = new Scalar(-1);
            return minus.mul(other.sub(this));
        }
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            Scalar scalarTemp = (Scalar) other;
            Scalar resultVar = new Scalar(this.value * scalarTemp.value);
            return resultVar;
        } else {
            return other.mul(this);
        }
    }

    @Override
    public Var div(Var other) {//если веркто или матрица - ошибка
        if (other instanceof Scalar) {
            Scalar scalarTemp = (Scalar) other;
            return new Scalar(this.value / scalarTemp.value);
        } else {
            return super.div(other);
        }
    }
}

